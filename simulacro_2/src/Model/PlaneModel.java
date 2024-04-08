package Model;
import DataBase.CRUD;
import DataBase.ConfigDB;
import Entity.Plane;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneModel implements CRUD{


    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Plane objPlane = (Plane) obj;
        try{
            String sql = "INSERT INTO plane (model,capacity) VALUES (?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1,objPlane.getModel());
            objPrepare.setInt(2, objPlane.getCapacity());
            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();

            while(objRest.next()){
                objPlane.setId_plane(objRest.getInt(1));
            }
            } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPlane;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listPlanes = new ArrayList<>();
        Connection objConnection  = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM plane;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while(objResult.next()){
                Plane objPlane = new Plane();
                objPlane.setId_plane(objResult.getInt("id_plane"));
                objPlane.setModel(objResult.getString("model"));
                objPlane.setCapacity(objResult.getInt("capacity"));
                listPlanes.add(objPlane);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return listPlanes;
    }

    @Override
    public boolean upDate(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Plane objPlane = (Plane) obj;
        boolean isUpDate = false;
        try {
            String sql = "UPDATE plane SET model = ?, capacity = ? WHERE id_plane = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objPlane.getModel());
            objPrepare.setInt(2, objPlane.getCapacity());
            objPrepare.setInt(3, objPlane.getId_plane());

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
        Plane objPlane = (Plane) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean idDelete = false;

        try {
            String sql = "DELETE FROM plane WHERE id_plane = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objPlane.getId_plane());
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
