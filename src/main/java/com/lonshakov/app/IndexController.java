package com.lonshakov.app;

import com.lonshakov.app.preview.index.IndexPreview;
import com.lonshakov.app.preview.index.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @Autowired
  private IndexService indexService;


  @GetMapping("/")
  public HttpEntity<IndexPreview> root() {
    return index();
  }

  @GetMapping("/index")
  public HttpEntity<IndexPreview> index() {
    IndexPreview preview = indexService.createPreview();
    return new ResponseEntity<>(preview, HttpStatus.OK);
  }


}
