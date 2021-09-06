package br.com.pozzo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicProducer {
	Logger logger = LoggerFactory.getLogger(TopicProducer.class);

	@Value("${topic.name.producer}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String key, String message) {
		logger.info("Payload enviado: {}", message);
		kafkaTemplate.send(topicName, key, message);
	}
}