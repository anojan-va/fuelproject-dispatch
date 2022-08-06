package com.lp.dispatch.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;



import com.lp.order.model.OrderEvent;

@Service
public class DispatchProducer {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DispatchProducer.class);
	
	private NewTopic topic;
	private KafkaTemplate<String, OrderEvent> kafkaTemplete;
	
	// constructor
	public DispatchProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplete) {
		super();
		this.topic = topic;
		this.kafkaTemplete = kafkaTemplete;
	} 
	
	public void sendMessage(OrderEvent event) {
		// save the allocation details and update the stock
		
		
		
		LOGGER.info(String.format("Order event => %s", event.getMessage()));
		
		// Create message
		Message<OrderEvent> message = MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, topic.name())
				.build();
		
		kafkaTemplete.send(message);
		
		
		
	}
}
