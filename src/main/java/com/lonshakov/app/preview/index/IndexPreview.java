package com.lonshakov.app.preview.index;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public class IndexPreview extends RepresentationModel<IndexPreview> {

  private List<IndexRecordPreview> indexRecords;

  public IndexPreview(List<IndexRecordPreview> indexRecords) {
    this.indexRecords = indexRecords;
  }

  public List<IndexRecordPreview> getIndexRecords() {
    return indexRecords;
  }
}
