package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Bureau;
import com.example.cesi.seating_plan.model.Plan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PlanDAO extends DAO<Plan> {
    @Override
    public boolean create(Plan obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery("INSERT INTO plan (libelle, version) VALUES ("+obj.getLibelle()+","+obj.getVersion()+")") ;

            return result.rowInserted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Plan obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery("DELETE FROM plan WHERE id = " + String.valueOf(obj.getId()));

            return result.rowDeleted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Plan obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery("UPDATE plan SET libelle = "+obj.getLibelle()+", version = "+obj.getVersion()+" WHERE id = "+ String.valueOf(obj.getId())) ;

            return result.rowUpdated();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Plan find(long id) {
        Plan plan = new Plan();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM plan WHERE id = " + String.valueOf(id));
            if(result.first()){
                BureauDAO bureauDAO = new BureauDAO();

                plan.setId(result.getLong("id"));
                plan.setLibelle(result.getString("libelle"));
                plan.setVersion(result.getInt("version"));

                plan.setBureauList(bureauDAO.findAllByPlan(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plan;
    }

    public List<Plan> findall() {
        List<Plan> partieList = new LinkedList<>();

        Plan plan;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM plan");
            while (result.next()) {
                plan = new Plan();
                BureauDAO bureauDAO = new BureauDAO();

                plan.setId(result.getLong("id"));
                plan.setLibelle(result.getString("libelle"));
                plan.setVersion(result.getInt("version"));

                plan.setBureauList(bureauDAO.findAllByPlan(result.getLong("id")));

                partieList.add(plan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partieList;
    }
}
