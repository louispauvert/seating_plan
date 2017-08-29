package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Bureau;

public class BureauDAO extends DAO<Bureau> {
    @Override
    public boolean create(Bureau obj) {
        return false;
    }

    @Override
    public boolean delete(Bureau obj) {
        return false;
    }

    @Override
    public boolean update(Bureau obj) {
        return false;
    }

    @Override
    public Bureau find(long id) {
        return null;
    }
}
