package com.zyx.lambda.boot;

import java.util.List;

import com.zyx.lambda.repository.Person;
import com.zyx.lambda.service.robo.RoboContactMethods2;

public class RoboCallTest02 {

	public static void main(String[] args) {
		List<Person> list = Person.createShortList();
		RoboContactMethods2 robo = new RoboContactMethods2();

		System.out.println("==== Test 02 ====");
		System.out.println("=== Calling all Drivers ===");
		robo.callDrivers(list);

		System.out.println("=== Emailing all Draftees ===");
		robo.emailDraftees(list);

		System.out.println("=== Mail all Pilots ===");
		robo.mailPilots(list);
	}

}
