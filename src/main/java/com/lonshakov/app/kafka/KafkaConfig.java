package com.lonshakov.app.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapAddress;

  @Value("${spring.kafka.consumer.group-id}")
  private String groupId;

  @Value("${spring.kafka.topic}")
  private String topic;

  public String getBootstrapAddress() {
    return bootstrapAddress;
  }

  public String getGroupId() {
    return groupId;
  }

  public String getTopic() {
    return topic;
  }
}
