package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.MaterielDAO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MaterielController {
    MaterielDAO materielDAO = new MaterielDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Long id) {

        return materielDAO.find(id).toString();
    }
}
