package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Etage;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class EtageDAO extends DAO<Etage> {

    @Override
    public boolean create(Etage obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO etage (libelle) VALUES ("+obj.getLibelle()+")") ;

            return result.rowInserted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Etage obj) {

        return false;
    }

    @Override
    public boolean update(Etage obj) {

        return false;
    }

    @Override
    public Etage find(long id) {

        return null;
    }
}
