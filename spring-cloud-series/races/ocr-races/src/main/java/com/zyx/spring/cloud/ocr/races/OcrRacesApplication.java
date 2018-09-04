package com.zyx.spring.cloud.ocr.races;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class OcrRacesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OcrRacesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		races.add(new Race("Spartan Beast", "123", "MA", "Boston"));
		races.add(new Race("Tough Mudder RI", "456", "RI", "Providence"));
	}

	private static List<Race> races = new ArrayList<>();

	@RequestMapping("/")
	public List<Race> getRaces() {
		return races;
	}

	@Autowired
	ParticipantsBean participantsBean;

	@RequestMapping(value = "/participants")
	public List<RaceWithParticipants> getRacesWithParticipatns() {
		List<RaceWithParticipants> result = new ArrayList<>();
		for (Race race : races) {
			result.add(new RaceWithParticipants(race, participantsBean.getParticipants(race.getId())));
		}
		return result;
	}
	
	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(
				streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}
}
