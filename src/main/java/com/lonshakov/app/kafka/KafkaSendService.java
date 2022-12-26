package com.lonshakov.app.kafka;

import com.lonshakov.app.preview.kafka.KafkaPreview;
import com.lonshakov.app.preview.kafka.KafkaPreviewService;
import com.lonshakov.app.preview.kafka.KafkaRecordPreview;
import com.lonshakov.app.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaSendService {

  @Autowired
  private KafkaPreviewService kafkaPreviewService;

  @Autowired
  private KafkaSender kafkaSender;

  public KafkaPreview send(String message) {
    kafkaSender.sendMessage(message);

    KafkaPreview preview = kafkaPreviewService.createPreview();
    preview.addRecords(recordPreview(message));
    return preview;
  }

  private List<KafkaRecordPreview> recordPreview(String message) {
    List<KafkaRecordPreview> recordPreviews = new ArrayList<>();
    recordPreviews.add(new KafkaRecordPreview(KafkaRecordPreview.KafkaRecordStatus.SENT, message));
    return recordPreviews;
  }

}
