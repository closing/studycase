package com.zyx.lambda.boot;

import java.util.List;

import com.zyx.lambda.repository.Person;

public class NameTestNew {

	public static void main(String[] args) {
		System.out.println("=== NameTestNew ===");

		List<Person> list = Person.createShortList();

		System.out.println("=== Custom List ===");
		for (Person person : list) {
			System.out.println(
					person.printCustom(function -> "Name: " + person.getGivenName() + "Email: " + person.getEmail()));
		}

		
	}

}
