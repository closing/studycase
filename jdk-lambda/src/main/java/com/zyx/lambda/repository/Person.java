package com.zyx.lambda.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.zyx.lambda.Gender;

public class Person {
	private String givenName;
	private String surName;
	private int age;
	private Gender gender;
	private String email;
	private String phone;
	private String address;

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void printName() {
		System.out.println(this.surName);
	}

	public String printCustom(Function<Person, String> function) {
		return function.apply(this);
	}

	public void print() {
		System.out.println(
				"\nName: " + givenName + " " + surName + "\n" +
						"Age: " + age + "\n" +
						"Gender: " + gender + "\n" +
						"eMail: " + email + "\n" +
						"Phone: " + phone + "\n" +
						"Address: " + address + "\n");
	}

	@Override
	public String toString() {
		return "Name: " + givenName + " " + surName + "\n" + "Age: " + age + "  Gender: " + gender + "\n" + "eMail: "
				+ email + "\n";
	}

	private Person() {
		super();
	}

	private Person(Person.Builder builder) {
		this.givenName = builder.givenName;
		this.surName = builder.surName;
		this.age = builder.age;
		this.gender = builder.gender;
		this.email = builder.email;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	public static class Builder {
		private String givenName = "";
		private String surName = "";
		private int age = 0;
		private Gender gender = Gender.FEMALE;
		private String email = "";
		private String phone = "";
		private String address = "";

		public Person.Builder givenName(String givenName) {
			this.givenName = givenName;
			return this;
		}

		public Person.Builder surName(String surName) {
			this.surName = surName;
			return this;
		}

		public Person.Builder age(int age) {
			this.age = age;
			return this;
		}

		public Person.Builder gender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public Person.Builder email(String email) {
			this.email = email;
			return this;
		}

		public Person.Builder phoneNumber(String phone) {
			this.phone = phone;
			return this;
		}

		public Person.Builder address(String address) {
			this.address = address;
			return this;
		}

		public Person build() {
			return new Person(this);
		}
	}

	public static List<Person> createShortList() {
		List<Person> people = new ArrayList<>();
		people.add(
				new Person.Builder()
						.givenName("Bob")
						.surName("Baker")
						.age(21)
						.gender(Gender.MALE)
						.email("bob.baker@example.com")
						.phoneNumber("201-121-4678")
						.address("44 4th St, Smallville, KS 12333")
						.build());

		people.add(
				new Person.Builder()
						.givenName("Jane")
						.surName("Doe")
						.age(25)
						.gender(Gender.FEMALE)
						.email("jane.doe@example.com")
						.phoneNumber("202-123-4678")
						.address("33 3rd St, Smallville, KS 12333")
						.build());

		people.add(
				new Person.Builder()
						.givenName("John")
						.surName("Doe")
						.age(25)
						.gender(Gender.MALE)
						.email("john.doe@example.com")
						.phoneNumber("202-123-4678")
						.address("33 3rd St, Smallville, KS 12333")
						.build());

		people.add(
				new Person.Builder()
						.givenName("James")
						.surName("Johnson")
						.age(45)
						.gender(Gender.MALE)
						.email("james.johnson@example.com")
						.phoneNumber("333-456-1233")
						.address("201 2nd St, New York, NY 12111")
						.build());

		people.add(
				new Person.Builder()
						.givenName("Joe")
						.surName("Bailey")
						.age(67)
						.gender(Gender.MALE)
						.email("joebob.bailey@example.com")
						.phoneNumber("112-111-1111")
						.address("111 1st St, Town, CA 11111")
						.build());

		people.add(
				new Person.Builder()
						.givenName("Phil")
						.surName("Smith")
						.age(55)
						.gender(Gender.MALE)
						.email("phil.smith@examp;e.com")
						.phoneNumber("222-33-1234")
						.address("22 2nd St, New Park, CO 222333")
						.build());

		people.add(
				new Person.Builder()
						.givenName("Betty")
						.surName("Jones")
						.age(85)
						.gender(Gender.FEMALE)
						.email("betty.jones@example.com")
						.phoneNumber("211-33-1234")
						.address("22 4th St, New Park, CO 222333")
						.build());

		return people;
	}
}
