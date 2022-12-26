package com.lonshakov.app.preview.index;

import com.lonshakov.app.IndexController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class IndexService {

  @Autowired
  private IndexRecordConfig indexConfig;

  public IndexPreview createPreview() {
    IndexPreview preview = new IndexPreview(indexRecordPreview());
    preview.add(linkTo(methodOn(IndexController.class).index()).withSelfRel());
    return preview;
  }


  private List<IndexRecordPreview> indexRecordPreview() {
    List<IndexRecordPreview> previews = new ArrayList<>();
    previews.add(indexConfig.kafkaIndexRecord());
    return previews;
  }
}
