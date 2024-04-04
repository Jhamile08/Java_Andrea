package Model;

import DataBase.CRUD;
import DataBase.ConfigDB;
import Entity.Passenger;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerModel implements CRUD {

    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Passenger objPassenger = (Passenger) obj;
        try {
            String sql = "INSERT INTO passenger(name, surname, identity) VALUES(?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1,objPassenger.getName());
            objPrepare.setString(2, objPassenger.getSurname());
            objPrepare.setString(3, objPassenger.getIdentity());
            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();
            while (objRest.next()){
                objPassenger.setId_passenger(objRest.getInt(1));
            }
        } catch (SQLException e){
            JOptionPane.showInputDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPassenger;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listPassenger = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM passenger;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Passenger objPassenger = new Passenger();
                objPassenger.setId_passenger(objResult.getInt("id_passenger"));
                objPassenger.setName(objResult.getString("name"));
                objPassenger.setSurname(objResult.getString("surname"));
                objPassenger.setIdentity(objResult.getString("identity"));
                listPassenger.add(objPassenger);
            }
        }catch (SQLException e){
            JOptionPane.showInputDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return listPassenger;
    }

    @Override
    public boolean upDate(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Passenger objPassenger = (Passenger) obj;
        boolean isUpDate = false;
        try {
            String sql = "UPDATE passenger SET name = ?, surname = ?, identity = ? WHERE id_passenger = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objPassenger.getName());
            objPrepare.setString(2,objPassenger.getSurname());
            objPrepare.setString(3, objPassenger.getIdentity());
            int totalRowAffected = objPrepare.executeUpdate();
            if(totalRowAffected > 0){
                isUpDate = true;
                JOptionPane.showMessageDialog(null,"The update was succesful");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }

        return isUpDate;
    }

    @Override
    public boolean delete(Object obj) {
        Passenger objPassenger = (Passenger) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean idDelete = false;
        try {
            String sql = "DELETE FROM passenger WHERE id_passenger = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objPassenger.getId_passenger());
            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected > 0){
                idDelete = true;
                JOptionPane.showMessageDialog(null, "The delete was succesful");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return idDelete;
    }
}
