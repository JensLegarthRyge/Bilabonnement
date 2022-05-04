package com.example.bilabonnement.repositories;

import java.sql.*;

public class DatabaseConnectionManager {

    //Her connectes der til vores database med link, navn og kodeord.
    //Noget med Singleton
    public Connection getConnectionToDatabase(){
        Connection con = null;
        try {
            //con = DriverManager.getConnection("jdbc:mysql://votum.mysql.database.azure.com:3306/votum", "rootuser@votum", "JJMdat21a");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }


}
