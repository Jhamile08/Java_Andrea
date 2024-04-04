package model;

import database.CRUD;
import database.ConfigDB;
import entity.Medico;
import entity.Patient;

import javax.swing.*;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoModel implements CRUD {

    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Medico objMedico = (Medico) obj;
        try{
            String sql = "INSERT INTO medico (name,surname,id_specialty_foreing) VALUES (?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //Asign value to the ??
            objPrepare.setString(1, objMedico.getName());
            objPrepare.setString(2, objMedico.getSurname());
            objPrepare.setInt(3, objMedico.getId_specialty_foreing());
            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();

            while(objRest.next()){
                objMedico.setId_medico(objRest.getInt(1));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objMedico;
    }

    @Override
    public List<Object> findAll() {
        //Create list
        List<Object> listMedico = new ArrayList<>();
        //Open connection
        Connection objConnection = ConfigDB.openConnection();

        try{
            //SQL
            String sql = "SELECT * FROM medico;";
            //Use the preparateStatement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Execute query and get the result
            ResultSet objResult = objPrepare.executeQuery();
            //While exists an author
            while (objResult.next()) {
                Medico objMedico = new Medico();
                objMedico.setId_medico(objResult.getInt("id_medico"));
                objMedico.setName(objResult.getString("name"));
                objMedico.setSurname(objResult.getString("surname"));
                objMedico.setId_specialty_foreing(objResult.getInt("id_specialty_foreing"));
                listMedico.add(objMedico);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //Close the connection
        ConfigDB.closeConnection();
        return listMedico;
    }

    @Override
    public boolean upDate(Object obj) {
        //Open connection
        Connection objConnection = ConfigDB.openConnection();
        //Convert to author
        Medico objMedico = (Medico) obj;
        //Create a varible for know the state
        boolean isUpdate = false;
        try {
            //SQL
            String sql = "UPDATE medico SET name = ?, surname = ?, id_specialty_foreing = ? WHERE id_medico = ?;";
            //Create prepared statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Asign value to the query
            objPrepare.setString(1, objMedico.getName());
            objPrepare.setString(2, objMedico.getSurname());
            objPrepare.setInt(3, objMedico.getId_specialty_foreing());
            objPrepare.setInt(4, objMedico.getId_medico());
            //Execute query
            int totalRowAffected = objPrepare.executeUpdate();
            if(totalRowAffected > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null,"the update was succesful");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return isUpdate;
    }



    @Override
    public boolean delete(Object obj) {
        Medico objMedico = (Medico) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean idDelete = false;
        try{
            String sql = "DELETE FROM medico WHERE id_medico = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, objMedico.getId_medico());
            int totalRowAffected = objPrepare.executeUpdate();
            if(totalRowAffected > 0){
                idDelete = true;
                JOptionPane.showMessageDialog(null, "The delete was succesful");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        ConfigDB.closeConnection();
        return idDelete;
    }


    public Medico findById(int id) {
        //Open the connection
        Connection objConnection = ConfigDB.openConnection();
        //create book
        Medico objMedico = null;

        try {
            //Sql
            String sql = "SELECT * FROM medico WHERE id_medico = ?;";
            //Create prepare statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Asign value
            objPrepare.setInt(1, id);
            //Execute query
            ResultSet objResult = objPrepare.executeQuery();
            if(objResult.next()){
                objMedico = new Medico();
                objMedico.setName(objResult.getString("name"));
                objMedico.setSurname(objResult.getString("surname"));
                objMedico.setId_specialty_foreing(objResult.getInt("id_specialty_foreing"));
                objMedico.setId_medico(objResult.getInt("id_medico"));
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //Close connection
        ConfigDB.closeConnection();

        return objMedico;
    }
}
