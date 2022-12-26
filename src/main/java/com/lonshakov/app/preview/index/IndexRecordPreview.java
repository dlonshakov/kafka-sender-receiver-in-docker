package com.lonshakov.app.preview.index;

import org.springframework.hateoas.RepresentationModel;

public class IndexRecordPreview extends RepresentationModel<IndexRecordPreview> {

  private String description;

  public IndexRecordPreview(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
