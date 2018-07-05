package com.jms.p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Receiver {
	public static void main(String[] args) {
		// JMS Connection Factory
		ConnectionFactory connectionFactory;
		// JMS Connection
		Connection connection = null;
		// JMS Session
		Session session = null;
		// JMS Destination
		Destination destination;
		// JMS C
		MessageConsumer consumer;

		try {
			connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
					ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("FirstQueue");
			consumer = session.createConsumer(destination);
			while (true) {
				TextMessage message = (TextMessage) consumer.receive(100000);
				if (message != null) {
					System.out.println("Received Message: " + message);
					// } else {
					//break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (null != connection) {
					connection.close();
				}

			} catch (Throwable ignore) {

			}
		}

	}

}
