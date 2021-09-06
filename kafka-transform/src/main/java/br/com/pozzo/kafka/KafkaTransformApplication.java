package br.com.pozzo.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class KafkaTransformApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaTransformApplication.class, args);
	}

}
