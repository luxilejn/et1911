package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloConsumer {

	public static void main(String[] args) throws JMSException {
		// 1. 创建ConnectionFactory
		ConnectionFactory factory = new //
		ActiveMQConnectionFactory(null, null, //
				"tcp://localhost:61616");
		// 2. 创建Connection，并调用start()方法
		Connection connection = factory.createConnection();
		connection.start();
		
		// 3. 创建Session
		Session session = connection.createSession(false, //
				Session.AUTO_ACKNOWLEDGE);
		// 4. 创建Destination(消费来源)
		Queue helloQueue = session.createQueue("hello");

		// 5. 创建消费者
		MessageConsumer consumer = session.createConsumer(helloQueue);

		// 6. 消费消息
		TextMessage text = (TextMessage) consumer.receive();
		System.out.println(text.getText().toString());
		consumer.close();
		session.close();
		connection.close();
	}
}
