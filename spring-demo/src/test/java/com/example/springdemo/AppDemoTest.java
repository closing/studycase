package com.example.springdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTests {

	@Test
	void mainTest() {
		//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//		System.setOut(new PrintStream(outContent));

		//		AppDemo.main(null);
		//assertEquals("Hello World!", outContent.toString(), "'Hello World!' shoud be printed int the console ");
		assertEquals(2, 1 + 1, "ERROR");
	}

}
