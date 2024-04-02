package model;

import database.CRUD;
import database.ConfigDB;
import entity.Medico;
import entity.Patient;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MedicoModel implements CRUD {

    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Medico objMedico = (Medico) obj;
        try{
            String sql = "INSERT INTO medico (name,surname,id_specialty) VALUES (?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //Asign value to the ??
            objPrepare.setString(1, objMedico.getName());
            objPrepare.setString(2, objMedico.getSurname());
            objPrepare.setInt(3, objMedico.getId_specialty());
            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();

            while(objRest.next()){
                objMedico.setId_medico(objRest.getInt(1));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return objMedico;
    }

    @Override
    public List<Patient> findAll() {
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
