package de.reichi.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/fun")
public class JokesController {
    @RequestMapping(method = RequestMethod.GET , value = "/fun/tell_a_joke")
    public String joke(){
        return "If we shouldn't eat at night, then why is there a light bulb in the fridge";
    }
}
