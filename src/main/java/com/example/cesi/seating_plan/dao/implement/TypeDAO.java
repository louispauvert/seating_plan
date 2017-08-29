package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Type;

public class TypeDAO extends DAO<Type> {
    @Override
    public boolean create(Type obj) {
        return false;
    }

    @Override
    public boolean delete(Type obj) {
        return false;
    }

    @Override
    public boolean update(Type obj) {
        return false;
    }

    @Override
    public Type find(long id) {
        return null;
    }
}
