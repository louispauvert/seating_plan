package com.example.cesi.seating_plan.servlets;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eliot on 22/09/2017.
 */

@RestController
public class BatimenteController {

    @RequestMapping(value = "/batiment", method = RequestMethod.GET)
    @ResponseBody
    public String Ntm () {
        return "ftg";
    }

}
