package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.TypeDAO;
import com.example.cesi.seating_plan.model.Type;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ListIterator;

@Controller
@RequestMapping("/type")
public class TypeController {
    private TypeDAO typeDAO = new TypeDAO();

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Integer id) {

        return typeDAO.find(id).toString();
    }

    @RequestMapping(value = "/id/all", method = RequestMethod.GET)
    public String findAll(){
        ListIterator listIterator = typeDAO.findall().listIterator();

        String liste = "";

        while (listIterator.hasNext()){
            liste = liste.concat(listIterator.next().toString());
        }
        return  liste;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteOne(@PathVariable("id") Integer id) {
        Type type= new Type();

        type.setId(id);

        return typeDAO.delete(type);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public @ResponseBody boolean updateOne(@PathVariable("id") Integer id) {
        Type type = new Type();

        type.setId(id);

        return typeDAO.update(type);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody boolean createOne(@RequestBody Type type) {
        return typeDAO.create(type);
    }
}
