package Model;
import DataBase.CRUD;
import DataBase.ConfigDB;
import Entity.Plane;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
