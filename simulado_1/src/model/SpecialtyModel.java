package model;

import database.CRUD;
import database.ConfigDB;
import entity.Patient;
import entity.Specialty;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Specialty objSpecialty = (Specialty) obj;

        try{
            String sql = "INSERT INTO specialty (name,description) VALUES (?,?);";
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
    public List<Patient> findAll() {
        //Create list
        List<Object> listSpecialty = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try{
            String sql = "SELECT * FROM specialty;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();

            while(objResult.next()){
                Specialty objSpecialty = new Specialty();
                objSpecialty.setId_specialty(objResult.getInt("id_specialty"));
                objSpecialty.setName(objResult.getString("name"));
                objSpecialty.setDescription(objResult.getString("description"));
                listSpecialty.add(objSpecialty);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        ConfigDB.closeConnection();
        return listSpecialty;
    }

    @Override
    public boolean upDate(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Specialty objSpecialty = (Specialty) obj;
        boolean isUpDate = false;
        try {
            String sql = "UPDATE specialty SET name = ?, description = ? WHERE id_specialty = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objSpecialty.getName());
            objPrepare.setString(2, objSpecialty.getDescription());
            objPrepare.setInt(3, objSpecialty.getId_specialty());

            //Execute query
            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected > 0){
                isUpDate = true;
                JOptionPane.showMessageDialog(null,"the update was succesful");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return isUpDate;
    }

    @Override
    public boolean delete(Object obj) {
        Specialty objSpecialty = (Specialty) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean idDelete = false;
        try {
            String sql = "DELETE FROM specialty WHERE id_specialty = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, objSpecialty.getId_specialty());
            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected > 0){
                idDelete = true;
                JOptionPane.showMessageDialog(null, "the delete was succeful");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return idDelete;
    }

    public Specialty findById(int id) {
        //Open the connection
        Connection objConnection = ConfigDB.openConnection();
        //create book
        Specialty objSpecialty = null;

        try {
            //Sql
            String sql = "SELECT * FROM specialty WHERE id_specialty = ?;";
            //Create prepare statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Asign value
            objPrepare.setInt(1, id);
            //Execute query
            ResultSet objResult = objPrepare.executeQuery();
            if(objResult.next()){
                objSpecialty = new Specialty();
                objSpecialty.setName(objResult.getString("name"));
                objSpecialty.setDescription(objResult.getString("description"));
                objSpecialty.setId_specialty(objResult.getInt("id_specialty"));
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //Close connection
        ConfigDB.closeConnection();

        return objSpecialty;
    }
}
