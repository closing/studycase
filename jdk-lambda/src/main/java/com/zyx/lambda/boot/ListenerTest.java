package com.zyx.lambda.boot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ListenerTest {

	public static void main(String[] args) {
		JButton testButton = new JButton("Button");
		testButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click Detected by Anon class");
			}
		});

		testButton.addActionListener(e -> System.out.println("Click Detected by Lambda  Listner"));

		JFrame frame = new JFrame("Listener Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(testButton);
		frame.pack();
		frame.setVisible(true);
	}

}
