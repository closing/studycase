package com.zyx.spring.cloud.ocr.races;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("participants")
public interface ParticipantsClient {
	@RequestMapping(value = "/races/{raceId}", method = RequestMethod.GET)
	List<Participant> getParticipants(@PathVariable("raceId") String raceId);
}
