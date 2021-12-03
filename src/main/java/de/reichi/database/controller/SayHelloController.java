package de.reichi.database.controller;

import de.reichi.database.entity.Greeting;
import de.reichi.database.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SayHelloController {

  @Autowired
  private GreetingRepository greetingRepository;

  @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Greeting> sayHello() {
    return ResponseEntity.ok(new Greeting("default"));
  }

  @RequestMapping(value = "/say/hello/{myFriend}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Greeting> sayHelloMyFriend(@PathVariable String myFriend) {
    return ResponseEntity.ok(new Greeting(myFriend));
  }

  @RequestMapping(value = "/hello/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Greeting>> findGreetingsByMessageDetail(@RequestParam(value = "message", defaultValue = "") String message) {
    return ResponseEntity.ok(this.greetingRepository.findByMessageContaining(message).orElse(List.of()));
  }

  /**
   * Initialize database after context creation
   * @param event event thrown after context initialization completed
   */
  @EventListener
  public void onApplicationEvent(ContextRefreshedEvent event) {
    List<Greeting> greetings = List.of(new Greeting("hello world"),
    new Greeting("hallo world"),
    new Greeting("hello dat"),
    new Greeting("hello ranjith"),
    new Greeting("hallo reichi"));

    this.greetingRepository.saveAll(greetings);
  }
}
