package com.zyx.spring.cloud.ocr.races;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ParticipantsBean {
	@Autowired
	private ParticipantsClient participantsClient;

	@HystrixCommand(fallbackMethod = "defaultParticipants")
	public List<Participant> getParticipants(String raceId) {
		return participantsClient.getParticipants(raceId);
	}

	public List<Participant> defaultParticipants(String raceId) {
		return new ArrayList<Participant>();
	}
}
