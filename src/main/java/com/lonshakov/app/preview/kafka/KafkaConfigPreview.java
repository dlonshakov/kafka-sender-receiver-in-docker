package com.lonshakov.app.preview.kafka;

import org.springframework.hateoas.RepresentationModel;

public class KafkaConfigPreview {

  private String bootstrapServices;

  private String groupId;

  private String topic;


  public KafkaConfigPreview(String bootstrapServices, String groupId, String topic) {
    this.bootstrapServices = bootstrapServices;
    this.groupId = groupId;
    this.topic = topic;
  }

  public String getBootstrapServices() {
    return bootstrapServices;
  }

  public String getGroupId() {
    return groupId;
  }

  public String getTopic() {
    return topic;
  }
}
