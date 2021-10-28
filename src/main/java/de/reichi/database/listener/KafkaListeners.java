package de.reichi.database.listener;

import de.reichi.database.entity.Contract;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaListeners {

  @KafkaListener(topics = "contracts", groupId = "foo")
  public void listenGroupFoo(Contract message) {
    System.out.println("Received Message in group foo: " + message);
  }
}
