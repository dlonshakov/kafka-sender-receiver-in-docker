package com.lonshakov.app;

import com.lonshakov.app.kafka.KafkaSendService;
import com.lonshakov.app.preview.kafka.KafkaPreview;
import com.lonshakov.app.preview.kafka.KafkaPreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

  @Autowired
  private KafkaPreviewService kafkaPreviewService;

  @Autowired
  private KafkaSendService kafkaSendService;


  @GetMapping("/kafka")
  public HttpEntity<KafkaPreview> kafka() {
    KafkaPreview preview = kafkaPreviewService.createPreview();
    return new ResponseEntity<>(preview, HttpStatus.OK);
  }

  @PostMapping("/kafka")
  public HttpEntity<KafkaPreview> producer(@RequestBody String requestMessage) {
    KafkaPreview preview = kafkaSendService.send(requestMessage);
    return new ResponseEntity<>(preview, HttpStatus.OK);
  }

}
