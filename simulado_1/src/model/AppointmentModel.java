package model;

import database.CRUD;
import database.ConfigDB;
import entity.Appointment;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AppointmentModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Appointment objAppoitment = (Appointment) obj;
        try{
            String sql = "INSERT INTO appoitment (id_medico,id_patient,date_appoitment,hour_appoitment,reason) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //Asign value to the ??
            objPrepare.setInt(1, objAppoitment.getId_medico_appointment());
            objPrepare.setInt(2, objAppoitment.getId_patient_appointment());
            objPrepare.setString(3, objAppoitment.getDate_appointment());
            objPrepare.setString(3, objAppoitment.getHour_appointment());
            objPrepare.setString(3, objAppoitment.getReason());
            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();

            while(objRest.next()){
                objAppoitment.setId_appointment(objRest.getInt(1));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAppoitment;
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
