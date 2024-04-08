package Model;

import DataBase.CRUD;
import DataBase.ConfigDB;
import Entity.Plane;
import Entity.Reservation;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Reservation objReservation = (Reservation) obj;
        try{
            String sql = "INSERT INTO reservation (reservation_time,seat,id_passenger,id_flight) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1,objReservation.getReservation_time());
            objPrepare.setString(2, objReservation.getSeat());
            objPrepare.setInt(3,objReservation.getId_passenger());
            objPrepare.setInt(4, objReservation.getId_flight());

            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();

            while(objRest.next()){
                objReservation.setId_reservation(objRest.getInt(1));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfigDB.closeConnection();
        return objReservation;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listReservation = new ArrayList<>();
        Connection objConnection  = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM reservation;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while(objResult.next()){
                Reservation objReservation = new Reservation();
                objReservation.setId_reservation(objResult.getInt("id_reservation"));
                objReservation.setReservation_time(objResult.getString("reservation_time"));
                objReservation.setSeat(objResult.getString("seat"));
                objReservation.setId_passenger(objResult.getInt("id_passenger"));
                objReservation.setId_flight(objResult.getInt("id_flight"));

                listReservation.add(objReservation);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return listReservation;
    }

    @Override
    public boolean upDate(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Reservation objReservation = (Reservation) obj;
        boolean isUpDate = false;
        try {
            String sql = "UPDATE reservation SET reservation_time = ?, seat = ?, id_passenger = ?, id_flight = ? WHERE id_reservation = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objReservation.getReservation_time());
            objPrepare.setString(2, objReservation.getSeat());
            objPrepare.setInt(3, objReservation.getId_passenger());
            objPrepare.setInt(4, objReservation.getId_flight());
            objPrepare.setInt(5, objReservation.getId_reservation());

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
        Reservation objReservation = (Reservation) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean idDelete = false;

        try {
            String sql = "DELETE FROM reservation WHERE id_reservation = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objReservation.getId_reservation());
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
    public boolean verifyCapacity(int idVuelo){
        Connection objConenction = ConfigDB.openConnection();
        boolean avaible = false;
        try{
            String sql = "SELECT COUNT(*) AS total_reservation, flight.id_plane, plane.capacity\n" +
                    "FROM reservation \n" +
                    "INNER JOIN flight ON reservation.id_flight = flight.id_flight\n" +
                    "INNER JOIN plane ON flight.id_plane = plane.id_plane\n" +
                    "WHERE reservation.id_flight = ?;";
            PreparedStatement objPrepare = objConenction.prepareStatement(sql);
            objPrepare.setInt(1, idVuelo);
            ResultSet objResult = objPrepare.executeQuery();
            if (objResult.next()) {
                int totalReservation = objResult.getInt("total_reservation");
                int totalPlaneCapacity = objResult.getInt("capacity");
                if (totalReservation >= totalPlaneCapacity) {
                    JOptionPane.showMessageDialog(null, "This plane is full, please choose another.");
                    return false;
                }
                return true;
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    return avaible;
    }


}
