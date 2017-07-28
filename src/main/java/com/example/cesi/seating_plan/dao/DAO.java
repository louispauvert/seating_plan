package com.example.cesi.seating_plan.dao;

import com.example.cesi.seating_plan.dao.implement.ConnectionMysql;

import java.sql.Connection;

public abstract class DAO<T> {
    public Connection connect = ConnectionMysql.getInstance();

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    public abstract boolean create(T obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    public abstract boolean delete(T obj);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    public abstract boolean update(T obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    public abstract T find(long id);
}
