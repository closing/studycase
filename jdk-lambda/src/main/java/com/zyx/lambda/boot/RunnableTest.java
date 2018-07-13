package com.zyx.lambda.boot;

public class RunnableTest {
	public static void main(String[] args) {
		System.out.println("=== RunnableTest ===");
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello world one!");
			}

		};
		Runnable r2 = () -> System.out.println("Hello world two!");
		r1.run();
		r2.run();
	}
}
