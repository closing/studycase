package com.zyx.lambda.service.robo;

import java.util.List;
import java.util.function.Predicate;

import com.zyx.lambda.repository.Person;

public class RoboContactLambda {
	public void phoneContacts(List<Person> list, Predicate<Person> pred) {
		for (Person person : list) {
			if (pred.test(person)) {
				roboCall(person);
			}
		}

	}

	public void emailContacts(List<Person> list, Predicate<Person> pred) {
		for (Person person : list) {
			if (pred.test(person)) {
				roboEmail(person);
			}
		}

	}

	public void mailContacts(List<Person> list, Predicate<Person> pred) {
		for (Person person : list) {
			if (pred.test(person)) {
				roboMail(person);
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
				"EMailing  " + person.getGivenName() + " " + person.getSurName() + " age " + person.getAge() + " at "
						+ person.getEmail());

	}

	public void roboMail(Person person) {
		System.out.println(
				"Mailing  " + person.getGivenName() + " " + person.getSurName() + " age " + person.getAge() + " at "
						+ person.getAddress());

	}

}
