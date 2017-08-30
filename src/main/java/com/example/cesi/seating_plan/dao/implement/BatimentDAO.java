package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Batiment;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class BatimentDAO extends DAO<Batiment> {
    @Override
    public boolean create(Batiment obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO batiment (libelle) VALUES ("+obj.getLibelle()+")") ;

            return result.rowInserted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Batiment obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM batiment WHERE id = " + String.valueOf(obj.getId()));

            return result.rowDeleted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Batiment obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE batiment SET libelle = "+obj.getLibelle()+"WHERE id = "+String.valueOf(obj.getId())) ;

            return result.rowUpdated();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Batiment find(long id) {
        Batiment batiment = new Batiment("");

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM batiment WHERE id = " + String.valueOf(id));
            if(result.first())
                batiment = new Batiment(
                        id,
                        result.getString("libelle")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batiment;
    }
    public List<Batiment> findall() {
        List<Batiment> batimentList = new LinkedList<>();

        Batiment batiment = new Batiment("");

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM batiment");
            while (result.next()) {
                batiment = new Batiment(
                        result.getLong("id"),
                        result.getString("libelle")
                );

                batimentList.add(batiment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batimentList;
    }
}
