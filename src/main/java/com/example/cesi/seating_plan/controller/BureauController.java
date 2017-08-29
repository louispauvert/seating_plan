package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.BureauDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bureau")
public class BureauController {
    BureauDAO bureauDAO = new BureauDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Long id) {

        return bureauDAO.find(id).toString();
    }
}
