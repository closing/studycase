package com.zyx.lambda.boot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.zyx.lambda.repository.Person;

public class ComparatorTest {
	public static void main(String[] args) {
		List<Person> personList = Person.createShortList();

		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person person1, Person person2) {
				return person1.getSurName().compareTo(person2.getSurName());
			}
		});

		System.out.println("=== Sorted Asc SurName ===");
		for (Person p : personList) {
			p.printName();
		}

		// Use Lambda
		System.out.println("=== Sorted Asc SurName ===");
		Collections.sort(personList, (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));
		for (Person p : personList) {
			p.printName();
		}

		System.out.println("=== Sorted Desc SurName ===");
		Collections.sort(personList, (p1, p2) -> p2.getSurName().compareTo(p1.getSurName()));
		for (Person p : personList) {
			p.printName();
		}
	}

}
