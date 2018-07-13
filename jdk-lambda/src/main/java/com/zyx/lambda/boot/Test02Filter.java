package com.zyx.lambda.boot;

import java.util.List;

import com.zyx.lambda.repository.Person;
import com.zyx.lambda.service.robo.SearchCriteria;

public class Test02Filter {
	public static void main(String[] args) {

		List<Person> list = Person.createShortList();
		SearchCriteria search = SearchCriteria.getInstance();

		System.out.println("=== allDraftees ===");
		list.stream().filter(search.getCriteria("allDraftees")).forEach(p -> System.out.println(p.getGivenName()));
	}

}
