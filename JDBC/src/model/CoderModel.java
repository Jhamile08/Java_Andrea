package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {

    @Override
    public Object insert(Object obj) {
        //1. Abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();
        //2. Convertir el obj que llego a coder
        Coder objCoder = (Coder) obj;
        try {
            // 3. Escribir el SQL
            String sql = "INSERT INTO coder (name,age,clan) VALUES (?,?,?)";
            //4. Preparar el statement, ademas agregar la propiedad RETURN_GENERATED_KEYS que hace la sentencia SQL nos retorne los id generados por la bs
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //5. Asignar valor a los ???
            objPrepare.setString(1, objCoder.getName());
            objPrepare.setInt(2,objCoder.getAge());
            objPrepare.setString(3, objCoder.getClan());
            //6. ejecutar el query
            objPrepare.execute();
            //7. Obtener el resultado con los id(llaves generadas)
            ResultSet objRest = objPrepare.getGeneratedKeys();
            //8. mientras haya un registro
            while (objRest.next()){
                // Podemos obtener el valor tambien con indices
                objCoder.setId(objRest.getInt(1));

            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return objCoder;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listCoders = new ArrayList<>();
        //2. Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        try{
            //3. Escribimos el query en sql
            String sql = "SELECT * FROM coder;";
            //4. Usar el preparateStatement
            PreparedStatement objPrepare =  objConnection.prepareStatement(sql);
            //5. Ejecutar el query y obtener el resultado (Result test)
            ResultSet objResult =  objPrepare.executeQuery();
            //6. mientras haya un resultado siguiente hacer
            while(objResult.next()){
                Coder objCoder = new Coder();
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setId(objResult.getInt("id"));
                objCoder.setClan(objResult.getString("Clan"));
                listCoders.add(objCoder);
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        //7.
        ConfigDB.closeConnection();
        return listCoders;
    }

    @Override
    public boolean upDate(Object obj) {

        return false;
    }

    @Override
    public boolean delete(Object obj) {
        //1. Convertir el objeto a la entidad
        Coder objCoder = (Coder) obj;
        //2. Abrir la conexion
        Connection objConnection =  ConfigDB.openConnection();
        //3. Crear una variable de estado
        boolean isDeleted = false;

        try {
            //4. Escribir la sentencia sql
            String sql = "DELETE FROM coder WHERE id = ?;";
            //5. Creamos el prepare statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //6. Dar valor al ?
            objPrepare.setInt(1, objCoder.getId());
            //7. Ejecutamos le Query (executeUpdate) devuelve le numero de registros afectados
            int totalAffectedRows =  objPrepare.executeUpdate();
            //Si las fulas afectadas fueron mayor a cero quiere decir que si elimino algo
            if(totalAffectedRows > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"the update was succesful");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //8. Cerramos la conexion
        ConfigDB.closeConnection();
        return isDeleted;
    }

    public Coder findById(int id){
        //1. abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();
        //2. Crear el coder que vamos a retornar
        Coder objCoder = null;

        try{
            //3. Sentencia SQL
            String sql = "SELECT * FROM coder WHERE id = ?;";
            //4. Preparamos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //5. Darle valor al parametro
            objPrepare.setInt(1,id);
            //6.Ejecutamos el Query
            ResultSet objResult = objPrepare.executeQuery();
            if(objResult.next()){
                objCoder = new Coder();
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setId(objResult.getInt("id"));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        };
        //7. Cerrar la conexion
        ConfigDB.closeConnection();
        return objCoder;
    }

    public List<Coder> findByname(String nameFound){
        List<Coder> listCoders = new ArrayList<>();
        //1. abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();


        try {
            // Sentencia sql
            String sql = "SELECT * FROM coder WHERE name like ?;";
            // Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            // valor al parametro
            objPrepare.setString(1,"%"+"name"+"%");
            //Ejecutamos el Query
            ResultSet objResult = objPrepare.executeQuery();
            while(objResult.next()) {
               Coder objCoder = new Coder();
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setId(objResult.getInt("id"));
                listCoders.add(objCoder);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        // Cerrar la conexion
        ConfigDB.closeConnection();
        return listCoders;
    }
}
