package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.EtageDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/etage")
public class EtageController {
    EtageDAO etageDAO = new EtageDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Long id) {

        return etageDAO.find(id).toString();
    }
}
