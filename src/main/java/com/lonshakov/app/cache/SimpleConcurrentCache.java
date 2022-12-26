package com.lonshakov.app.cache;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import static java.util.Arrays.asList;

@Component
public class SimpleConcurrentCache {

  private ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

  public void add(String message) {
    queue.add(message);
  }

  public List<String> readAndPurge() {
    List<String> messages = new ArrayList<>();
    synchronized (queue){
      messages = asList(queue.toArray(new String[0]));
      queue.removeAll(messages);
    }
    return messages;
  }

}
