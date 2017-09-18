package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.BatimentDAO;
import com.example.cesi.seating_plan.model.Batiment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.io.Console;
import java.util.ListIterator;

@Controller
@RequestMapping("/batiment")
public class BatimentController {
    BatimentDAO batimentDAO = new BatimentDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Long id) {

        return batimentDAO.find(id).toString();
    }

    @RequestMapping(value = "/id/all", method = RequestMethod.GET)
    public String findAll(){
        ListIterator listIterator = batimentDAO.findall().listIterator();

        String liste = "";

        while (listIterator.hasNext()){
            liste = liste.concat(listIterator.next().toString());
        }
        return  liste;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public boolean deleteOne(@PathVariable("id") Long id) {
        Batiment batiment = new Batiment();

        batiment.setId(id);

        return batimentDAO.delete(batiment);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public boolean updateOne(@PathVariable("id") Long id) {
        Batiment batiment = new Batiment();

        batiment.setId(id);

        return batimentDAO.update(batiment);
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean createOne(@RequestBody String libelle) {
        Batiment batiment = new Batiment(libelle);

        System.out.println(batiment.toString());

        return batimentDAO.create(batiment);
    }
}
