package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.BureauDAO;
import com.example.cesi.seating_plan.model.Bureau;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListIterator;

@Controller
@RequestMapping("/bureau")
public class BureauController {
    private BureauDAO bureauDAO = new BureauDAO();
    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody String base() {

        return "/bureau/            GET     => liste des commandes \n" +
               "/bureau/id/1        GET     => affiche le bureau correspondant à id = 1 \n" +
               "/bureau/id/all      GET     => Affiche tous les bureaux \n" +
               "/bureau/count/1     GET     => affiche le nombre total de bureau pour le plan correspondant à id = 1 \n" +
               "/bureau/count/      GET     => affiche le nombre total de bureau \n" +
               "/bureau/id/1        DELETE  => supprime le bureau correspondant à id = 1 \n" +
               "/bureau/id/1        PUT     => update le bureau correspondant à id = 1 et renseigner dans le body id_collab peut etre renseigné \n" +
               "/bureau/            POST    => créer le bureau correspondant renseigner dans le body id_collab peut etre renseigné \n";
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET, headers="Accept=application/json")
    public @ResponseBody String findOne(@PathVariable("id") String id) {

        Bureau test;
        test = bureauDAO.find(Long.valueOf(id));

        try {
           return mapper.writeValueAsString(test);
        } catch (JsonProcessingException e) {
            return e.toString();
        }
    }

    @RequestMapping(value = "/id/all", method = RequestMethod.GET, headers="Accept=application/json")
    public @ResponseBody String findAll(){
        List<Bureau> bureauList = bureauDAO.findAll();

        try {
            return mapper.writeValueAsString(bureauList);
        } catch (JsonProcessingException e) {
            return e.toString();
        }
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteOne(@PathVariable("id") Integer id) {
        Bureau bureau = new Bureau();

        bureau.setId(id);

        return bureauDAO.delete(bureau);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public @ResponseBody boolean updateOne(@PathVariable("id") Integer id,@RequestBody Bureau bureau) {

        bureau.setId(id);

        return bureauDAO.update(bureau);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody boolean createOne(@RequestBody Bureau bureau) {
        return bureauDAO.create(bureau);
    }

    @RequestMapping(value = "/count/{id}", method = RequestMethod.GET)
    public @ResponseBody int countByPlan(@PathVariable String id) {
        return bureauDAO.countByPlan(Long.valueOf(id));
    }

    @RequestMapping(value = "/count/", method = RequestMethod.GET)
    public @ResponseBody int createOne() {
        return bureauDAO.count();
    }
}
