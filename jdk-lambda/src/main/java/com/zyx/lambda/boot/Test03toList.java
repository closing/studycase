package com.zyx.lambda.boot;

import java.util.List;
import java.util.stream.Collectors;

import com.zyx.lambda.repository.Person;
import com.zyx.lambda.service.robo.SearchCriteria;

public class Test03toList {

	public static void main(String[] args) {
		List<Person> list = Person.createShortList();
		SearchCriteria search = SearchCriteria.getInstance();
		List<Person> pilotList = list
				.stream()
				.filter(search.getCriteria("allPilots"))
				.collect(Collectors.toList());
		System.out.println("=== All Pilots ===");
		pilotList.forEach(p -> System.out.println(p.getGivenName()));
	}

}
