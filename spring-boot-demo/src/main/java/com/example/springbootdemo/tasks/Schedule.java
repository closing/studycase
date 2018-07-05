package com.example.springbootdemo.tasks;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule  {
	Logger LOGGER = LoggerFactory.getLogger(Schedule.class);

	@Scheduled(fixedRate = 2000)
	public void task() {
		LOGGER.debug("Start task at " + new Date());
	}
}
