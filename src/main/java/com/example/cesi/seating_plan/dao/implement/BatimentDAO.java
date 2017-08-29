package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Batiment;

public class BatimentDAO extends DAO<Batiment> {
    @Override
    public boolean create(Batiment obj) {
        return false;
    }

    @Override
    public boolean delete(Batiment obj) {
        return false;
    }

    @Override
    public boolean update(Batiment obj) {
        return false;
    }

    @Override
    public Batiment find(long id) {
        return null;
    }
}
