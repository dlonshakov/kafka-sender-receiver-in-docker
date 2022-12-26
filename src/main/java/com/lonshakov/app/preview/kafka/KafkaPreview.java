package com.lonshakov.app.preview.kafka;

import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

public class KafkaPreview extends RepresentationModel<KafkaPreview> {

  private String description;

  private KafkaConfigPreview config;

  private List<KafkaRecordPreview> records = new ArrayList<>();

  public KafkaPreview() {
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public KafkaConfigPreview getConfig() {
    return config;
  }

  public void setConfig(KafkaConfigPreview config) {
    this.config = config;
  }

  public List<KafkaRecordPreview> getRecords() {
    return records;
  }

  public void addRecords(List<KafkaRecordPreview> records) {
    this.records.addAll(records);
  }
}
