package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.BatimentDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/batiment")
public class BatimentController {
    BatimentDAO batimentDAO = new BatimentDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Long id) {

        return batimentDAO.find(id).toString();
    }
}
