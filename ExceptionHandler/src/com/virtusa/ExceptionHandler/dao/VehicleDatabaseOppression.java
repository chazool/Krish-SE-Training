package com.virtusa.ExceptionHandler.dao;

import com.virtusa.ExceptionHandler.entity.Vehicle;
import com.virtusa.ExceptionHandler.exeption.DatabaseAuthondicationExeption;
import com.virtusa.ExceptionHandler.exeption.DatabaseLibraryException;
import com.virtusa.ExceptionHandler.exeption.SqlOpprationExeption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class VehicleDatabaseOppression {

    public boolean saveVehicle(Vehicle vehicle) throws DatabaseAuthondicationExeption, DatabaseLibraryException {
        boolean bool = false;
        Connection con = DatabaseConnection.getconnection();
        try {
            String sql = "sql statements";

            PreparedStatement st = con.prepareStatement(sql);

            bool = st.execute();
            st.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SqlOpprationExeption("Sql operation Fail ", ex);
        }
        return bool;
    }



}
