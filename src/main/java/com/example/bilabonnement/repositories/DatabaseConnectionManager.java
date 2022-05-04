package com.example.bilabonnement.repositories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static String url;
    private static String username;
    private static String password;
    private static Connection conn;

    private DatabaseConnectionManager(){}
    //Her connectes der til vores database med link, navn og kodeord.
    //Noget med Singleton
    public static Connection getConnection(){
        if(conn != null){
            return conn;
        }
        try(InputStream propertiesFile = new FileInputStream("src/main/resources/application.properties")) {
            Properties props = new Properties();
            props.load(propertiesFile);
            url = props.getProperty("db.url");
            System.out.println(url);
            username = props.getProperty("db.username");
            System.out.println(username);
            password = props.getProperty("db.password");
            System.out.println(password);
            conn = DriverManager.getConnection(url, username, password);

        }

        catch(SQLException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }


}
