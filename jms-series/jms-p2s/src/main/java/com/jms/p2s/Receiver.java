package com.jms.p2s;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
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
					ActiveMQConnection.DEFAULT_PASSWORD, ActiveMQConnection.DEFAULT_BROKER_URL);
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			destination = session.createTopic("topic1");
			consumer = session.createConsumer(destination);
			consumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					try {
						System.out.println("Received message: " + ((TextMessage) message).getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}

				}

			});
			System.in.read();
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
