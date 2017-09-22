package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Materiel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MaterielDAO extends DAO<Materiel> {
    @Override
    public boolean create(Materiel obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery("INSERT INTO materiel (libelle, id_type) VALUES ("+obj.getLibelle()+", "+", "+obj.getId_type()+")") ;

            return result.rowInserted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Materiel obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery("DELETE FROM materiel WHERE id = " + String.valueOf(obj.getId()));

            return result.rowDeleted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Materiel obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery("UPDATE materiel SET libelle = "+obj.getLibelle()+", nombre = "+",id_type = "+obj.getId_type()+" WHERE id = "+ String.valueOf(obj.getId())) ;

            return result.rowUpdated();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Materiel find(long id) {
        Materiel materiel = new Materiel();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM materiel WHERE id = " + String.valueOf(id));
            if(result.first()){
                TypeDAO typeDAO= new TypeDAO();

                materiel.setType_materiel(typeDAO.find(result.getLong("id_type")));

                materiel.setLibelle(result.getString("libelle"));
                materiel.setId_type(result.getLong("id_type"));
                materiel.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiel;
    }

    public List<Materiel> findAll() {
        List<Materiel> materielList = new LinkedList<>();

        Materiel materiel;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * " +
                                                                    "FROM contenir " +
                                                                    "LEFT JOIN materiel ON contenir.id_four = materiel.id");
            while (result.next()) {
                materiel = new Materiel();
                TypeDAO typeDAO = new TypeDAO();

                materiel.setId(result.getLong("id"));
                materiel.setLibelle(result.getString("libelle"));
                materiel.setId_type(result.getLong("id_type"));

                materiel.setType_materiel(typeDAO.find(result.getLong("id_type")));

                materielList.add(materiel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materielList;
    }

    public List<Materiel> findAllByBureauId(long id) {
        List<Materiel> materielList = new LinkedList<>();

        Materiel materiel;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * " +
                                                                    "FROM contenir " +
                                                                    "LEFT JOIN materiel ON contenir.id_four = materiel.id " +
                                                                    "WHERE contenir.id_bureau = "+String.valueOf(id));
            while (result.next()) {
                materiel = new Materiel();
                TypeDAO typeDAO = new TypeDAO();

                materiel.setId(result.getLong("id"));
                materiel.setLibelle(result.getString("libelle"));
                materiel.setId_type(result.getLong("id_type"));

                materiel.setType_materiel(typeDAO.find(result.getLong("id_type")));

                materielList.add(materiel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materielList;
    }
}
