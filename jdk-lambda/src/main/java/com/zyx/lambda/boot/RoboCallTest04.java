package com.zyx.lambda.boot;

import java.util.List;

import com.zyx.lambda.Gender;
import com.zyx.lambda.repository.Person;
import com.zyx.lambda.service.robo.RoboContactLambda;

public class RoboCallTest04 {

	public static void main(String[] args) {

		List<Person> list = Person.createShortList();

		RoboContactLambda robo = new RoboContactLambda();
		System.out.println("=== Test04 ===");
		System.out.println("=== Calling all Drivers ===");
		robo.phoneContacts(list, person -> person.getAge() >= 16);
		System.out.println("=== EMailing all Draftees ===");
		robo.emailContacts(list,
				person -> person.getAge() >= 18 && person.getAge() <= 25 && person.getGender() == Gender.MALE);

		System.out.println("=== Mail all Pilots ===");
		robo.mailContacts(list, person -> person.getAge() >= 23 && person.getAge() <= 65);

	}
}
