package com.example.cesi.seating_plan.dao.implement;

import com.example.cesi.seating_plan.dao.DAO;
import com.example.cesi.seating_plan.model.Bureau;
import com.example.cesi.seating_plan.model.Collaborateur;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class BureauDAO extends DAO<Bureau> {
    @Override
    public boolean create(Bureau obj) {
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery("INSERT INTO bureau (id_collab) VALUES ("+obj.getId_collab()+")") ;

            return result.rowInserted();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Bureau obj) {
        try {
            int result = this.connect.createStatement().executeUpdate("DELETE FROM bureau WHERE id = " + String.valueOf(obj.getId()));

            return result == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Bureau obj) {
        try {
            int result = this.connect.createStatement().executeUpdate("UPDATE bureau SET id_collab = "+obj.getId_collab()+" WHERE id = "+ String.valueOf(obj.getId())) ;

            return result == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Bureau find(long id) {
        Bureau bureau = new Bureau();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * " +
                                                                    "FROM bureau " +
                                                                    "LEFT JOIN avoir ON bureau.id = avoir.id_bureau " +
                                                                    "LEFT JOIN contenir ON bureau.id = contenir.id_bureau " +
                                                                    "WHERE bureau.id = " + String.valueOf(id));
            if(result.first()){
                MaterielDAO materielDAO = new MaterielDAO();
                CollaborateurDAO collaborateurDAO = new CollaborateurDAO();
                PlanDAO planDAO = new PlanDAO();

                bureau.setId_collab(result.getLong("id_collab"));
                bureau.setId(result.getLong("id"));
                bureau.setNum_externe(result.getInt("num_externe"));
                bureau.setNum_interne(result.getInt("num_interne"));
                bureau.setAbs(result.getInt("abs"));
                bureau.setOrd(result.getInt("ord"));
                bureau.setSens(result.getBoolean("sens"));

                bureau.setListMateriel(materielDAO.findAllByBureauId(id));

                bureau.setPlan(planDAO.find(result.getLong("id_plan")));

                bureau.setCollaborateur(collaborateurDAO.find(result.getLong("id_collab")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bureau;
    }

    public List<Bureau> findAll() {
        List<Bureau> bureauList = new LinkedList<>();

        Bureau bureau;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * " +
                                                                    "FROM bureau ");
            while (result.next()) {
                bureau = find(result.getLong("id"));

                bureauList.add(bureau);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bureauList;
    }

    public List<Bureau> findAllByPlan(long id) {
        List<Bureau> bureauList = new LinkedList<>();

        Bureau bureau;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * " +
                                                                    "FROM bureau " +
                                                                    "LEFT JOIN avoir ON bureau.id = avoir.id_bureau " +
                                                                    "LEFT JOIN contenir ON bureau.id = contenir.id_bureau " +
                                                                    "WHERE id_plan = "+String.valueOf(id));
            while (result.next()) {
                MaterielDAO materielDAO = new MaterielDAO();
                CollaborateurDAO collaborateurDAO = new CollaborateurDAO();
                PlanDAO planDAO = new PlanDAO();

                bureau = new Bureau();

                bureau.setId_collab(result.getLong("id_collab"));
                bureau.setId(result.getLong("id"));
                bureau.setNum_externe(result.getInt("num_externe"));
                bureau.setNum_interne(result.getInt("num_interne"));
                bureau.setAbs(result.getInt("abs"));
                bureau.setOrd(result.getInt("ord"));
                bureau.setSens(result.getBoolean("sens"));

                bureau.setListMateriel(materielDAO.findAllByBureauId(result.getLong("id")));

                bureau.setCollaborateur(collaborateurDAO.find(result.getLong("id_collab")));

                bureau.setPlan(planDAO.find(result.getLong("id_plan")));

                bureauList.add(bureau);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bureauList;
    }

    public int count() {
        int nombre = -1;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) AS 'nombre' FROM bureau");
            if(result.first()){
                nombre = result.getInt("nombre");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombre;
    }

    public int countByPlan(long id) {
        int nombre = -1;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) AS 'nombre' FROM avoir WHERE avoir.id_plan= "+String.valueOf(id));
            if(result.first()){
                nombre = result.getInt("nombre");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombre;
    }
}
