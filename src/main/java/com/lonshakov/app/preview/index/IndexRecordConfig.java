package com.lonshakov.app.preview.index;

import com.lonshakov.app.KafkaController;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class IndexRecordConfig {

  public IndexRecordPreview kafkaIndexRecord() {
    IndexRecordPreview preview = new IndexRecordPreview("Follow url to see kafka");
    preview.add(linkTo(methodOn(KafkaController.class).kafka()).withRel("/kafka"));
    return preview;
  }
}
