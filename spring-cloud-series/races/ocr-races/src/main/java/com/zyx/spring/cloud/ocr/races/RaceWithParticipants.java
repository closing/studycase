package com.zyx.spring.cloud.ocr.races;

import java.util.ArrayList;
import java.util.List;

public class RaceWithParticipants extends Race {
	private List<Participant> participants = new ArrayList<>();

	public RaceWithParticipants(Race r, List<Participant> participants) {
		super(r.getName(), r.getId(), r.getState(), r.getCity());
		this.participants = participants;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

}
