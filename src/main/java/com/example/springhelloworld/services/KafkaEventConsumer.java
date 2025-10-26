package com.example.springhelloworld.services;

import com.example.springhelloworld.model.QuickstartEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaEventConsumer.class);

    @KafkaListener(topics = "${app.kafka.topic.example}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(QuickstartEvent event,
                       @Header(value = KafkaHeaders.RECEIVED_KEY, required = false) String key,
                       @Header(value = KafkaHeaders.RECEIVED_TOPIC, required = false) String topic) {
        try {
            log.info("Received Kafka message on topic='{}' key='{}' payload={}", topic, key, event);
            // TODO: implement processing logic here
        } catch (Exception e) {
            log.error("Error processing Kafka message: key={} payload={}", key, event, e);
            // Optionally rethrow or handle according to error handling policy
        }
    }
}
