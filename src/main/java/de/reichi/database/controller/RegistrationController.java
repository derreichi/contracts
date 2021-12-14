package de.reichi.database.controller;

import de.reichi.database.entity.Greeting;
import de.reichi.database.entity.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {



        /*@RequestMapping(value = "/user/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<User> RegistrationForm() {
            return ResponseEntity.ok(new User("Max"));
        }
        }*/

}
