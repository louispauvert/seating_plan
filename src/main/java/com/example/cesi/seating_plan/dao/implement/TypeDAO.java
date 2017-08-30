package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TypeDAO extends DAO<Type> {
    @Override
    public boolean create(Type obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO type (libelle) VALUES ("+obj.getLibelle()+")") ;

            return result.rowInserted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Type obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM type WHERE id = " + String.valueOf(obj.getId()));

            return result.rowDeleted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Type obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE type SET libelle = "+obj.getLibelle()+" WHERE id = "+ String.valueOf(obj.getId())) ;

            return result.rowUpdated();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Type find(long id) {
        Type type = new Type();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM type WHERE id = " + String.valueOf(id));
            if(result.first())
                type = new Type(
                        id,
                        result.getString("libelle")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    public List<Type> findall() {
        List<Type> typeList = new LinkedList<>();

        Type type;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM type");
            while (result.next()) {
                type = new Type(
                        result.getLong("id"),
                        result.getString("libelle")
                );

                typeList.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeList;
    }
}
