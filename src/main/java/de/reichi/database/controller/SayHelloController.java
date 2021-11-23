package de.reichi.database.controller;

import de.reichi.database.entity.Greeting;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {

  @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Greeting> sayHello() {
    return ResponseEntity.ok(new Greeting("default"));
  }

  @RequestMapping(value = "/say/hello/{myFriend}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Greeting> sayHelloMyFriend(@PathVariable String myFriend) {
    return ResponseEntity.ok(new Greeting(myFriend));
  }
}
