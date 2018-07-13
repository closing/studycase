package com.zyx.lambda.service.robo;

import java.util.List;

import com.zyx.lambda.Gender;
import com.zyx.lambda.repository.Person;

public class RoboContactMethods {
	public void callDrivers(List<Person> list) {
		for (Person p : list) {
			if (p.getAge() >= 16) {
				roboCall(p);
			}
		}
	}

	public void emailDraftees(List<Person> list) {
		for (Person p : list) {
			if (p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE) {
				roboEmail(p);
			}

		}
	}

	public void mailPilots(List<Person> list) {
		for (Person p : list) {
			if (p.getAge() >= 23 && p.getAge() <= 65) {
				roboMail(p);
			}
		}
	}

	public void roboCall(Person person) {
		System.out.println(
				"Calling " + person.getGivenName() + " " + person.getSurName() + " age " + person.getAge() + " at "
						+ person.getPhone());
	}

	public void roboEmail(Person person) {
		System.out.println(
				"EMailing " + person.getGivenName() + " " + person.getSurName() + " age " + person.getAge() + " at "
						+ person.getEmail());

	}

	public void roboMail(Person person) {
		System.out.println(
				"Mailing " + person.getGivenName() + " " + person.getSurName() + " age " + person.getAge() + " at "
						+ person.getAddress());

	}
}
