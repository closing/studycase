package com.zyx.lambda.boot;

import java.util.List;

import com.zyx.lambda.repository.Person;

public class Test01ForEach {
	public static void main(String[] args) {

		List<Person> list = Person.createShortList();

		list.forEach(p -> System.out.println(p.getGivenName()));
	}

}
