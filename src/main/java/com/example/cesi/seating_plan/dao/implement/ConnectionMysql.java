package com.example.cesi.seating_plan.dao.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {

    /**
     * URL de connection
     */
    private static String url = "jdbc:mysql://localhost:3306/faittonplan?useSSL=false";
    /**
     * Nom du user
     */
    private static String user = "testuser";
    /**
     * Mot de passe du user
     */
    private static String passwd = "testuser";
    /**
     * Objet Connection
     */
    private static Connection connect;

    /**
     * Méthode qui va nous retourner notre instance
     * et la créer si elle n'existe pas...
     * @return
     */
    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
