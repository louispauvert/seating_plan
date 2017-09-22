package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Collaborateur;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
                    ResultSet.CONCUR_UPDATABLE).executeQuery("INSERT INTO collaborateur (nom, prenom, date_arrive, date_depart, email, mdp) VALUES ("+obj.getNom()+", "+obj.getPrenom()+", "+obj.getDate_arrive()+", "+obj.getDate_depart()+", "+obj.getEmail()+", "+obj.getMdp()+")") ;

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
                    ResultSet.CONCUR_UPDATABLE).executeQuery("DELETE FROM collaborateur WHERE id = " + String.valueOf(obj.getId()));

            return result.rowDeleted();

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
                    ResultSet.CONCUR_UPDATABLE).executeQuery("UPDATE collaborateur SET nom = "+obj.getNom()+", prenom = "+obj.getPrenom()+", date_arrive = "+obj.getDate_arrive()+", date_depart = "+ obj.getDate_depart()+", email = "+ obj.getEmail()+", mdp = "+ obj.getMdp()+" WHERE id = "+ String.valueOf(obj.getId())) ;

            return result.rowUpdated();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Collaborateur find(long id) {
        Collaborateur collaborateur = new Collaborateur();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM collaborateur WHERE id = " + String.valueOf(id));
            if(result.first()){
                collaborateur.setId(id);
                collaborateur.setNom(result.getString("nom"));
                collaborateur.setPrenom(result.getString("prenom"));
                collaborateur.setDate_arrive(result.getDate("date_arrive"));
                collaborateur.setDate_depart(result.getDate("date_depart"));
                collaborateur.setEmail(result.getString("email"));
                collaborateur.setMdp(result.getString("mdp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateur;
    }

    public List<Collaborateur> findall() {
        List<Collaborateur> collaborateurList = new LinkedList<>();

        Collaborateur collaborateur;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM collaborateur");
            while (result.next()) {
                collaborateur = new Collaborateur();

                collaborateur.setId(result.getLong("id"));
                collaborateur.setNom(result.getString("nom"));
                collaborateur.setPrenom(result.getString("prenom"));
                collaborateur.setDate_arrive(result.getDate("date_arrive"));
                collaborateur.setDate_depart(result.getDate("date_depart"));
                collaborateur.setEmail(result.getString("email"));
                collaborateur.setMdp(result.getString("mdp"));

                collaborateurList.add(collaborateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateurList;
    }
}
