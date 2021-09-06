package br.com.pozzo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TopicConsumer {
	Logger logger = LoggerFactory.getLogger(TopicConsumer.class);

	@Autowired
	private TopicProducer topicProducer;

	@Value("${topic.name.consumer")
	private String topicName;

	@KafkaListener(topics = "${topic.name.consumer}", groupId = "dummy-table-consumer")
	public void consume(ConsumerRecord<String, String> payload) {
		logger.info("Topico: {}", topicName);
		logger.info("key: {}", payload.key());
		logger.info("Headers: {}", payload.headers());
		logger.info("Partion: {}", payload.partition());
		logger.info("Value: {}", payload.value());
		topicProducer.send(payload.key(), payload.value());
	}
}