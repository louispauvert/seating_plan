package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.PartieDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/partie")
public class PartieController {
    PartieDAO partieDAO = new PartieDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Long id) {

        return partieDAO.find(id).toString();
    }
}
