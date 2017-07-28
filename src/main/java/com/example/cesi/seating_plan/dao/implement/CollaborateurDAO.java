package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Collaborateur;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class CollaborateurDAO extends DAO<Collaborateur> {

    public CollaborateurDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Collaborateur obj) {
        return false;
    }

    @Override
    public boolean delete(Collaborateur obj) {
        return false;
    }

    @Override
    public boolean update(Collaborateur obj) {
        return false;
    }

    @Override
    public Collaborateur find(long id) {
        Collaborateur collaborateur = new Collaborateur("","","");

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Collaborateur WHERE id = " + id);
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
}
