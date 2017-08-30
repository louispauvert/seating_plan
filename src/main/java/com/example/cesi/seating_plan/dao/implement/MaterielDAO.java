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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO materiel (libelle, nombre, id_type) VALUES ("+obj.getLibelle()+", "+obj.getNombre()+", "+obj.getId_type()+")") ;

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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM materiel WHERE id = " + String.valueOf(obj.getId()));

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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE materiel SET libelle = "+obj.getLibelle()+", nombre = "+obj.getNombre()+",id_type = "+obj.getId_type()+" WHERE id = "+ String.valueOf(obj.getId())) ;

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
            if(result.first())
                materiel = new Materiel(
                        id,
                        result.getString("libelle"),
                        result.getInt("nombre"),
                        result.getLong("id_type")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiel;
    }

    public List<Materiel> findall() {
        List<Materiel> materielList = new LinkedList<>();

        Materiel materiel;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM materiel");
            while (result.next()) {
                materiel = new Materiel(
                        result.getLong("id"),
                        result.getString("libelle"),
                        result.getInt("nombre"),
                        result.getLong("id_type")
                );

                materielList.add(materiel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materielList;
    }
}
