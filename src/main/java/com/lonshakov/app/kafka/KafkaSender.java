package com.lonshakov.app.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

  @Autowired
  private KafkaConfig kafkaConfig;

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String message) {
    kafkaTemplate.send(kafkaConfig.getTopic(), message);
    LOGGER.info("Sent Message {} to topic {}", message, kafkaConfig.getTopic());
  }
}
