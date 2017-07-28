package com.example.cesi.seating_plan.controller;

import com.example.cesi.seating_plan.dao.implement.CollaborateurDAO;
import com.example.cesi.seating_plan.dao.implement.ConnectionMysql;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller
@RequestMapping("/collaborateur/")
public class CollaborateurController {

    CollaborateurDAO collaborateurDAO = new CollaborateurDAO(ConnectionMysql.getInstance());

    @RequestMapping("/id")
    public String findOne(@PathVariable long id){
        return collaborateurDAO.find(id).toString();
    }
}
