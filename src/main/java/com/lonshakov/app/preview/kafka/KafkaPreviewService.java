package com.lonshakov.app.preview.kafka;

import com.lonshakov.app.IndexController;
import com.lonshakov.app.KafkaController;
import com.lonshakov.app.cache.CacheService;
import com.lonshakov.app.kafka.KafkaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class KafkaPreviewService {

  private static final String description = "Endpoint supports GET & POST methods. POST endpoint receives raw text message.";

  @Autowired
  private KafkaConfig config;

  @Autowired
  private CacheService cacheService;


  public KafkaPreview createPreview() {
    KafkaPreview preview = kafkaPreview();
    preview.add(linkTo(methodOn(KafkaController.class).kafka()).withSelfRel());
    preview.add(linkTo(methodOn(IndexController.class).index()).withRel("/index"));
    return preview;
  }

  private KafkaPreview kafkaPreview() {
    KafkaPreview preview = new KafkaPreview();
    preview.setDescription(description);
    preview.setConfig(configPreview());
    preview.addRecords(cacheService.cachedRecords());
    return preview;
  }

  private KafkaConfigPreview configPreview() {
    return new KafkaConfigPreview(config.getBootstrapAddress(), config.getGroupId(), config.getTopic());
  }
}
