package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.BatimentDAO;
import com.example.cesi.seating_plan.model.Batiment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ListIterator;

@Controller
@RequestMapping("/batiment")
public class BatimentController {
    private BatimentDAO batimentDAO = new BatimentDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public @ResponseBody String findOne(@PathVariable("id") Integer id) {
        return batimentDAO.find(id).toString();
    }

    @RequestMapping(value = "/id/all", method = RequestMethod.GET)
    public @ResponseBody String findAll(){
        ListIterator listIterator = batimentDAO.findAll().listIterator();

        String liste = "";

        while (listIterator.hasNext()){
            liste = liste.concat(listIterator.next().toString());
        }
        return  liste;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteOne(@PathVariable("id") Integer id) {
        Batiment batiment = new Batiment();

        batiment.setId(id);

        return batimentDAO.delete(batiment);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public @ResponseBody boolean updateOne(@PathVariable("id") Integer id) {
        Batiment batiment = new Batiment();

        batiment.setId(id);

        return batimentDAO.update(batiment);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody boolean createOne(@RequestBody Batiment batiment) {
        return batimentDAO.create(batiment);
    }
}
