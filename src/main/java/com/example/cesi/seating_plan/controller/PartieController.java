package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.PartieDAO;
import com.example.cesi.seating_plan.model.Partie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ListIterator;

@Controller
@RequestMapping("/partie")
public class PartieController {
    private PartieDAO partieDAO = new PartieDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Integer id) {

        return partieDAO.find(id).toString();
    }

    @RequestMapping(value = "/id/all", method = RequestMethod.GET)
    public String findAll(){
        ListIterator listIterator = partieDAO.findall().listIterator();

        String liste = "";

        while (listIterator.hasNext()){
            liste = liste.concat(listIterator.next().toString());
        }
        return  liste;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteOne(@PathVariable("id") Integer id) {
        Partie partie = new Partie();

        partie.setId(id);

        return partieDAO.delete(partie);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public @ResponseBody boolean updateOne(@PathVariable("id") Integer id) {
        Partie partie = new Partie();

        partie.setId(id);

        return partieDAO.update(partie);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody boolean createOne(@RequestBody Partie partie) {
        return partieDAO.create(partie);
    }
}
