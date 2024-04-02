package model;

import database.CRUD;
import database.ConfigDB;
import entity.Specialty;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SpecialtyModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Specialty objSpecialty = (Specialty) obj;

        try{
            String sql = "INSERT INTO specialty (name,description);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //Asign value to the ??
            objPrepare.setString(1, objSpecialty.getName());
            objPrepare.setString(2, objSpecialty.getDescription());

            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();

            while (objRest.next()){
                objSpecialty.setId_specialty(objRest.getInt(1));
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return objSpecialty;
    }

    @Override
    public List<Object> findAll() {
        return null;
    }

    @Override
    public boolean upDate(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
