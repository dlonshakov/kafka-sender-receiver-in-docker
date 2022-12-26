package com.lonshakov.app.preview.kafka;

public class KafkaRecordPreview {

  public enum KafkaRecordStatus {
    SENT, RECEIVED
  }

  private KafkaRecordStatus status;

  private String message;

  public KafkaRecordPreview(KafkaRecordStatus status, String message){
    this.status = status;
    this.message = message;
  }

  public KafkaRecordStatus getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
