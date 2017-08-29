package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Plan;

public class PlanDAO extends DAO<Plan> {
    @Override
    public boolean create(Plan obj) {
        return false;
    }

    @Override
    public boolean delete(Plan obj) {
        return false;
    }

    @Override
    public boolean update(Plan obj) {
        return false;
    }

    @Override
    public Plan find(long id) {
        return null;
    }
}
