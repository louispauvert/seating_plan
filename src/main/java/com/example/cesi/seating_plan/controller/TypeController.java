package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.TypeDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/type")
public class TypeController {
    TypeDAO typeDAO = new TypeDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Long id) {

        return typeDAO.find(id).toString();
    }
}
