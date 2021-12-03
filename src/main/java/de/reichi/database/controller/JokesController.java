package de.reichi.database.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokesController {
    @RequestMapping(method = RequestMethod.GET , value = "/fun/tell-a-joke")
    public ResponseEntity<String> joke(){
        return ResponseEntity.ok("If we shouldn't eat at night, then why is there a light bulb in the fridge") ;
    }
}
