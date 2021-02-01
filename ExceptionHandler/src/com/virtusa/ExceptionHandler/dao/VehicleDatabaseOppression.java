package com.chazool.ExceptionHandler.dao;

import com.chazool.ExceptionHandler.entity.Vehicle;
import com.chazool.ExceptionHandler.exeption.DatabaseAuthondicationException;
import com.chazool.ExceptionHandler.exeption.DatabaseLibraryException;
import com.chazool.ExceptionHandler.exeption.SqlOppressionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class VehicleDatabaseOppression {

    public boolean saveVehicle(Vehicle vehicle) throws DatabaseAuthondicationException, DatabaseLibraryException {
        boolean bool = false;
        Connection con = DatabaseConnection.getconnection();
        try {
            String sql = "sql statements";

            PreparedStatement st = con.prepareStatement(sql);

            bool = st.execute();
            st.close();
            con.close();

        } catch (SQLException ex) {

            throw new SqlOppressionException("Sql operation Fail ", ex);
        }
        return bool;
    }


}
