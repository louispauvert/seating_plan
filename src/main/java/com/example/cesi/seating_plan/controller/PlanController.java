package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.PlanDAO;
import com.example.cesi.seating_plan.model.Plan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ListIterator;

@Controller
@RequestMapping("/plan")
public class PlanController {
    private PlanDAO planDAO = new PlanDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Integer id) {

        return planDAO.find(id).toString();
    }

    @RequestMapping(value = "/id/all", method = RequestMethod.GET)
    public String findAll(){
        ListIterator listIterator = planDAO.findall().listIterator();

        String liste = "";

        while (listIterator.hasNext()){
            liste = liste.concat(listIterator.next().toString());
        }
        return  liste;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteOne(@PathVariable("id") Integer id) {
        Plan plan = new Plan();

        plan.setId(id);

        return planDAO.delete(plan);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public @ResponseBody boolean updateOne(@PathVariable("id") Integer id) {
        Plan plan = new Plan();

        plan.setId(id);

        return planDAO.update(plan);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody boolean createOne(@RequestBody Plan plan) {
        return planDAO.create(plan);
    }
}
