package com.zyx.lambda.boot;

import java.util.List;

import com.zyx.lambda.Gender;
import com.zyx.lambda.MyTest;
import com.zyx.lambda.repository.Person;
import com.zyx.lambda.service.robo.RoboContactAnon;

public class RoboCallTest03 {

	public static void main(String[] args) {
		List<Person> list = Person.createShortList();

		RoboContactAnon robo = new RoboContactAnon();
		System.out.println("=== Test03 ===");
		System.out.println("=== Calling all Drivers ===");
		robo.phoneContacts(list, new MyTest<Person>() {

			@Override
			public boolean test(Person person) {
				return person.getAge() >= 16;
			}

		});
		System.out.println("=== EMailing all Draftees ===");
		robo.emailContacts(list, new MyTest<Person>() {
			@Override
			public boolean test(Person person) {
				return person.getAge() >= 18 && person.getAge() <= 25 && person.getGender() == Gender.MALE;
			}
		});

		System.out.println("=== Mail all Pilots ===");
		robo.mailContacts(list, new MyTest<Person>() {
			@Override
			public boolean test(Person person) {
				return person.getAge() >= 23 && person.getAge() <= 65;
			}
		});
	}
}
