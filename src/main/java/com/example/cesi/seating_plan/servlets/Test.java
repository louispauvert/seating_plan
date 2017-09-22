package com.example.cesi.seating_plan.servlets;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by eliot on 18/09/2017.
 */

@RestController

public class Test {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String Hello() {
        System.out.println("Coucou");
        return "GGGG";
    }


}
