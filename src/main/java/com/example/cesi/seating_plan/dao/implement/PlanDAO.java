package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO plan (libelle, version) VALUES ("+obj.getLibelle()+","+obj.getVersion()+")") ;

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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM plan WHERE id = " + String.valueOf(obj.getId()));

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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE plan SET libelle = "+obj.getLibelle()+", version = "+obj.getVersion()+" WHERE id = "+ String.valueOf(obj.getId())) ;

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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM partie WHERE id = " + String.valueOf(id));
            if(result.first())
                plan = new Plan(
                        id,
                        result.getString("libelle"),
                        result.getInt("version")
                );
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM partie");
            while (result.next()) {
                plan = new Plan(
                        result.getLong("id"),
                        result.getString("libelle"),
                        result.getInt("version")
                );

                partieList.add(plan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partieList;
    }
}
