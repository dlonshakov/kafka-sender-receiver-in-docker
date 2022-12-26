package com.lonshakov.app.kafka;

import com.lonshakov.app.cache.SimpleConcurrentCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class FirstKafkaListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(FirstKafkaListener.class);
  @Autowired
  private KafkaConfig kafkaConfig;

  @Autowired
  private SimpleConcurrentCache cache;

  @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")

  public void listenGroup1(String message) {
    LOGGER.info("Received Message {} from topic {} in group {}", message, kafkaConfig.getTopic(), kafkaConfig.getGroupId());
    cache.add(message);
  }

}
