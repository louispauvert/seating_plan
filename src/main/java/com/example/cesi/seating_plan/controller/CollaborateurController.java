package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.CollaborateurDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/collaborateur")
public class CollaborateurController {

    CollaborateurDAO collaborateurDAO = new CollaborateurDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable long id){
        return collaborateurDAO.find(id).toString();
    }
}
