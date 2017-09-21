package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.CollaborateurDAO;
import com.example.cesi.seating_plan.model.Collaborateur;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ListIterator;

@Controller
@RequestMapping("/collaborateur")
public class CollaborateurController {
    private CollaborateurDAO collaborateurDAO = new CollaborateurDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Integer id){

        return collaborateurDAO.find(id).getNom();
    }

    @RequestMapping(value = "/id/all", method = RequestMethod.GET)
    public String findAll(){
        ListIterator listIterator = collaborateurDAO.findall().listIterator();

        String liste = "";

        while (listIterator.hasNext()){
            liste =liste.concat(listIterator.next().toString());
        }
        return  liste;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteOne(@PathVariable("id") Integer id) {
        Collaborateur collaborateur = new Collaborateur ();

        collaborateur.setId(id);

        return collaborateurDAO.delete(collaborateur);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public @ResponseBody boolean updateOne(@PathVariable("id") Integer id) {
        Collaborateur collaborateur = new Collaborateur ();

        collaborateur.setId(id);

        return collaborateurDAO.update(collaborateur);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody boolean createOne(@RequestBody Collaborateur collaborateur) {
        return collaborateurDAO.create(collaborateur);
    }
}
