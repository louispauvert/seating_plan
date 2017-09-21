package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.EtageDAO;
import com.example.cesi.seating_plan.model.Etage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ListIterator;

@Controller
@RequestMapping("/etage")
public class EtageController {
    private EtageDAO etageDAO = new EtageDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Integer id) {

        return etageDAO.find(id).toString();
    }

    @RequestMapping(value = "/id/all", method = RequestMethod.GET)
    public String findAll(){
        ListIterator listIterator = etageDAO.findall().listIterator();

        String liste = "";

        while (listIterator.hasNext()){
            liste = liste.concat(listIterator.next().toString());
        }
        return  liste;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteOne(@PathVariable("id") Integer id) {
        Etage etage = new Etage();

        etage.setId(id);

        return etageDAO.delete(etage);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public @ResponseBody boolean updateOne(@PathVariable("id") Integer id) {
        Etage etage = new Etage();

        etage.setId(id);

        return etageDAO.update(etage);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody boolean createOne(@RequestBody Etage etage) {
        return etageDAO.create(etage);
    }
}
