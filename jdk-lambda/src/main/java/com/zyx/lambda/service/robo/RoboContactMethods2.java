package com.zyx.lambda.service.robo;

import java.util.List;

import com.zyx.lambda.Gender;
import com.zyx.lambda.repository.Person;

public class RoboContactMethods2 {
	public void callDrivers(List<Person> list) {
		for (Person p : list) {
			if (isDriver(p)) {
				roboCall(p);
			}
		}
	}

	public void emailDraftees(List<Person> list) {
		for (Person p : list) {
			if (isDraftee(p)) {
				roboEmail(p);
			}

		}
	}

	public void mailPilots(List<Person> list) {
		for (Person p : list) {
			if (isPilot(p)) {
				roboMail(p);
			}
		}
	}

	public boolean isDriver(Person person) {
		return person.getAge() >= 16;
	}

	public boolean isDraftee(Person person) {

		return person.getAge() >= 18 && person.getAge() <= 25 && person.getGender() == Gender.MALE;
	}

	public boolean isPilot(Person person) {

		return person.getAge() >= 23 && person.getAge() <= 65;
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
