package Model;

import DataBase.CRUD;
import DataBase.ConfigDB;
import Entity.Flight;
import Entity.Plane;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Flight objFlight = (Flight) obj;
        try {
            String sql = "INSERT INTO flight(destination, departure_date, departure_time, id_plane) VALUES(?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objFlight.getDestination());
            objPrepare.setString(2, objFlight.getDeparture_date());
            objPrepare.setString(3, objFlight.getDeparture_time());
            objPrepare.setInt(4, objFlight.getId_plane());
            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();
            while(objRest.next()){
                objFlight.setId_flight(objRest.getInt(1));
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfigDB.closeConnection();
        return objFlight;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listFlight = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM flight;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while(objResult.next()) {
                Flight objFlight = new Flight();
                objFlight.setId_flight(objResult.getInt("id_flight"));
                objFlight.setDestination(objResult.getString("destination"));
                objFlight.setDeparture_date(objResult.getString("departure_date"));
                objFlight.setDeparture_time(objResult.getString("departure_time"));
                objFlight.setId_plane(objResult.getInt("id_plane"));
                listFlight.add(objFlight);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return listFlight;
    }

    @Override
    public boolean upDate(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Flight objFlight = (Flight) obj;
        boolean isUpDate = false;
        try {
            String sql = "UPDATE flight SET destination = ?, departure_date = ?, departure_time = ?, id_plane = ? WHERE id_flight = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objFlight.getDestination());
            objPrepare.setString(2, objFlight.getDeparture_date());
            objPrepare.setString(3, objFlight.getDeparture_time());
            objPrepare.setInt(4, objFlight.getId_plane());
            objPrepare.setInt(5, objFlight.getId_flight());

            int totalRowAffected = objPrepare.executeUpdate();
            if(totalRowAffected > 0){
                isUpDate = true;
                JOptionPane.showMessageDialog(null, "The update was succesful");
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
        Flight objFlight = (Flight) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean idDelete = false;

        try {
            String sql = "DELETE FROM flight WHERE id_flight = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objFlight.getId_flight());
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

