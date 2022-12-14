package com.lp.dispatch.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfigDispatch {
	
	@Value("${spring.kafka.topic.name-producer}")
	private String topicName;
	
	// spring bean for kafka topic
	
	@Bean
	public NewTopic topicDis() {
		return TopicBuilder.name(topicName)
				.build();
	}
}