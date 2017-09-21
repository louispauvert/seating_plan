package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.MaterielDAO;
import com.example.cesi.seating_plan.model.Materiel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ListIterator;

@Controller
@RequestMapping("/materiel")
public class MaterielController {
    private MaterielDAO materielDAO = new MaterielDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Integer id) {

        return materielDAO.find(id).toString();
    }

    @RequestMapping(value = "/id/all", method = RequestMethod.GET)
    public String findAll(){
        ListIterator listIterator = materielDAO.findAll().listIterator();

        String liste = "";

        while (listIterator.hasNext()){
            liste = liste.concat(listIterator.next().toString());
        }
        return  liste;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteOne(@PathVariable("id") Integer id) {
        Materiel materiel = new Materiel();

        materiel.setId(id);

        return materielDAO.delete(materiel);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public @ResponseBody boolean updateOne(@PathVariable("id") Integer id) {
        Materiel materiel = new Materiel();

        materiel.setId(id);

        return materielDAO.update(materiel);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody boolean createOne(@RequestBody Materiel materiel) {
        return materielDAO.create(materiel);
    }
}
