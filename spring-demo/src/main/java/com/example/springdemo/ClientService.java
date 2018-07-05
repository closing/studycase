package com.example.springdemo;

public class ClientService {

	private static ClientService clientService = new ClientService();

	public static ClientService createInstance() {
		return clientService;
	}

	public void SayHello() {
		System.out.println("Hello World! from ClientService");
	}
}
