package com.lonshakov.app.cache;

import com.lonshakov.app.preview.kafka.KafkaRecordPreview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CacheService {

  @Autowired
  private SimpleConcurrentCache cache;

  public List<KafkaRecordPreview> cachedRecords() {
    List<String> messages = cache.readAndPurge();
    return previews(messages);
  }

  private List<KafkaRecordPreview> previews(List<String> messages) {
    return messages.stream()
        .filter(Objects::nonNull)
        .map(message -> preview(message))
        .collect(Collectors.toList());
  }

  private KafkaRecordPreview preview(String message) {
    return new KafkaRecordPreview(KafkaRecordPreview.KafkaRecordStatus.RECEIVED, message);
  }


}
