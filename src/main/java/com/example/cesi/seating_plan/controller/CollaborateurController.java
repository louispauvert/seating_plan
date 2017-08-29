package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.CollaborateurDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ListIterator;

@Controller
@RequestMapping("/collaborateur")
public class CollaborateurController {
    CollaborateurDAO collaborateurDAO = new CollaborateurDAO();


    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Long id){

        return collaborateurDAO.find(id).toString();
    }

    @RequestMapping(value = "/id/all", method = RequestMethod.GET)
    public String findAll(){
        ListIterator listIterator = collaborateurDAO.findall().listIterator();

        String liste = "";

        while (listIterator.hasNext()){
            liste += listIterator.next().toString();
        }
        return  liste;
    }
}
