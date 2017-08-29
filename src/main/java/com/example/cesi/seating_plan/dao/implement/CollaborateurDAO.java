package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Collaborateur;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class CollaborateurDAO extends DAO<Collaborateur> {

    @Override
    public boolean create(Collaborateur obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO collaborateur (nom, prenom, date_arrive, date_depart, email, mdp) VALUES ("+obj.getNom()+", "+obj.getPrenom()+", "+obj.getDate_arrive()+", "+obj.getDate_depart()+", "+obj.getEmail()+", "+obj.getMdp()+")") ;

            return result.rowInserted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Collaborateur obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM collaborateur WHERE id = " + String.valueOf(obj.getId()));

            return result.rowInserted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Collaborateur obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE collaborateur SET nom = "+obj.getNom()+", prenom = "+obj.getPrenom()+", date_arrive = "+obj.getDate_arrive()+", date_depart = "+ obj.getDate_depart()+", email = "+ obj.getEmail()+", mdp = "+ obj.getMdp()) ;

            return result.rowUpdated();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Collaborateur find(long id) {
        Collaborateur collaborateur = new Collaborateur("","","");

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM collaborateur WHERE id = " + String.valueOf(id));
            if(result.first())
                collaborateur = new Collaborateur(
                        id,
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getDate("date_arrive"),
                        result.getDate("date_depart"),
                        result.getString("email"),
                        result.getString("mdp")
                        );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateur;
    }
    public List<Collaborateur> findall() {
        List<Collaborateur> collaborateurList = new LinkedList<>();

        Collaborateur collaborateur = new Collaborateur("","","");

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM collaborateur");
            while (result.next()) {
                collaborateur = new Collaborateur(
                        result.getLong("id"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getDate("date_arrive"),
                        result.getDate("date_depart"),
                        result.getString("email"),
                        result.getString("mdp")
                );

                collaborateurList.add(collaborateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateurList;
    }
}
