package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Partie;

public class PartieDAO extends DAO<Partie> {
    @Override
    public boolean create(Partie obj) {
        return false;
    }

    @Override
    public boolean delete(Partie obj) {
        return false;
    }

    @Override
    public boolean update(Partie obj) {
        return false;
    }

    @Override
    public Partie find(long id) {
        return null;
    }
}
