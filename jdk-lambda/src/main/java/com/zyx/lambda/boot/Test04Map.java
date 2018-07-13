package com.zyx.lambda.boot;

import java.util.List;
import java.util.OptionalDouble;

import com.zyx.lambda.repository.Person;
import com.zyx.lambda.service.robo.SearchCriteria;

public class Test04Map {
	public static void main(String[] args) {
		List<Person> list = Person.createShortList();
		SearchCriteria search = SearchCriteria.getInstance();
		System.out.println("== Cal Old Style ==");
		int sum = 0;
		int count = 0;
		for (Person person : list) {
			if (person.getAge() >= 23 && person.getAge() <= 65) {
				sum += person.getAge();
				count += 1;
			}
		}
		long average = sum / count;
		System.out.println("Total Ages: " + sum);
		System.out.println("Average Age:" + average);

		System.out.println("=== Cal New Styles");
		long totalAge = list
				.stream()
				.filter(search.getCriteria("allPilots"))
				.mapToInt(p -> p.getAge())
				.sum();

		OptionalDouble ob = list.parallelStream()
				.filter(search.getCriteria("allPilots"))
				.mapToDouble(p -> p.getAge())
				.average();
		System.out.println("Total Ages: " + totalAge);
		System.out.println("Average Age: " + ob.getAsDouble());
	}
}
