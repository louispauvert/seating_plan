package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.BureauDAO;
import com.example.cesi.seating_plan.model.Bureau;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ListIterator;

@Controller
@RequestMapping("/bureau")
public class BureauController {
    private BureauDAO bureauDAO = new BureauDAO();
    private ObjectMapper mapper = new ObjectMapper();

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

    @RequestMapping(value = "/id/all", method = RequestMethod.GET)
    public String findAll(){
        ListIterator listIterator = bureauDAO.findAll().listIterator();

        String liste = "";

        while (listIterator.hasNext()){
            liste = liste.concat(listIterator.next().toString());
        }
        return  liste;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteOne(@PathVariable("id") Integer id) {
        Bureau bureau = new Bureau();

        bureau.setId(id);

        return bureauDAO.delete(bureau);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public @ResponseBody boolean updateOne(@PathVariable("id") Integer id) {
        Bureau bureau = new Bureau();

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
