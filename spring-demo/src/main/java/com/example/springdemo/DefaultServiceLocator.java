package com.example.springdemo;

public class DefaultServiceLocator {
	private static ClientService clientService = new ClientService();

	public ClientService createClientServiceInstance() {
		return clientService;
	}
}
