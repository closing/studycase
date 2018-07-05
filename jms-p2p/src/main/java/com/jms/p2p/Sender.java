package com.jms.p2p;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Message Sender
 *
 */
public class Sender {
	public static void main(String[] args) throws Exception {

		// JMS Connection Factory
		ConnectionFactory connectionFactory;
		// JMS Connection
		Connection connection = null;
		// JMS Session
		Session session = null;
		// JMS Destination
		Destination destination;
		// JMS Producter
		MessageProducer producer;

		try {
			connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
					ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("FirstQueue");
			producer = session.createProducer(destination);
			while (true) {
				TextMessage message = session.createTextMessage("ActiveMQ message!!!" + new Date());
				producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
				producer.send(message);
				session.commit();
				Thread.sleep(10000);
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
