package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Partie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PartieDAO extends DAO<Partie> {
    @Override
    public boolean create(Partie obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery("INSERT INTO partie (libelle) VALUES ("+obj.getLibelle()+")") ;

            return result.rowInserted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Partie obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery("DELETE FROM partie WHERE id = " + String.valueOf(obj.getId()));

            return result.rowDeleted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Partie obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery("UPDATE partie SET libelle = "+obj.getLibelle()+" WHERE id = "+ String.valueOf(obj.getId())) ;

            return result.rowUpdated();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Partie find(long id) {
        Partie partie = new Partie();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM partie WHERE id = " + String.valueOf(id));
            if(result.first())
                partie = new Partie(
                        id,
                        result.getString("libelle")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partie;
    }

    public List<Partie> findall() {
        List<Partie> partieList = new LinkedList<>();

        Partie partie;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM partie");
            while (result.next()) {
                partie = new Partie(
                        result.getLong("id"),
                        result.getString("libelle")
                );

                partieList.add(partie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partieList;
    }
}
