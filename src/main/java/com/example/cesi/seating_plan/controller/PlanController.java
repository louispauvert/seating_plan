package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.PlanDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/plan")
public class PlanController {
    PlanDAO planDAO = new PlanDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Long id) {

        return planDAO.find(id).toString();
    }
}
