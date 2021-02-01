package com.chazool.ExceptionHandler.dao;

import com.chazool.ExceptionHandler.exeption.DatabaseAuthondicationException;
import com.chazool.ExceptionHandler.exeption.DatabaseLibraryException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    public  static Connection getconnection() throws DatabaseAuthondicationException,DatabaseLibraryException{

        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "1234";

        Connection con = null;
        try {
            //register Driver
            Class.forName("com.mysql.jdbc.Driver");
            //create the Connection
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException classNotFoundException) {
            throw  new DatabaseLibraryException("MySQL JDBC driver Library can not found ",classNotFoundException);
        }  catch (SQLException ex) {
            throw new DatabaseAuthondicationException("Please check your  Connection  Details , authentication problem  ", ex);
        }
        return con;
    }


}
