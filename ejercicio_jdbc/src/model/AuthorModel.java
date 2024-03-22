package model;
import database.CRUD;
import database.ConfigDB;
import entity.Author;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AuthorModel implements CRUD{

    @Override
    public Object insert(Object obj) {
        //Open connection
        Connection objConnection = ConfigDB.openConnection();
        //Convert object
        Author objAuthor = (Author) obj;
        try {
            //SQL
            String sql = "INSERT INTO author (name,nationality) VALUES (?, ?)";
            //Prepare statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //Asign value to the ??
            objPrepare.setString(1, objAuthor.getName());
            objPrepare.setString(2, objAuthor.getNationality());
            //Excecute query
            objPrepare.execute();
            //Get the result with the id
            ResultSet objRest = objPrepare.getGeneratedKeys();
            //While author exists
            while (objRest.next()) {
                //get the value with the index
                objAuthor.setId(objRest.getInt(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());

        }
        return objAuthor;
    }

    @Override
    public List<Object> findAll() {
        //Create list
        List<Object> listAuthors = new ArrayList<>();
        //Open connection
        Connection objConnection = ConfigDB.openConnection();

        try{
            //SQL
            String sql = "SELECT * FROM author;";
            //Use the preparateStatement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Execute query and get the result
            ResultSet objResult = objPrepare.executeQuery();
            //While exists an author
            while (objResult.next()) {
                Author objAuthor = new Author();
                objAuthor.setName(objResult.getString("name"));
                objAuthor.setNationality(objResult.getString("nationality"));
                listAuthors.add(objAuthor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //Close the connection
        ConfigDB.closeConnection();
        return listAuthors;
    }

    @Override
    public boolean upDate(Object obj) {
        //Open connection
        Connection objConnection = ConfigDB.openConnection();
        //Convert to author
        Author objAuthor = (Author) obj;
        //Create a varible for know the state
        boolean isUpdate = false;
        try {
            //SQL
            String sql = "UPDATE author SET name = ?, nationality = ? WHERE id = ?;";
            //Create prepared statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Asign value to the query
            objPrepare.setString(1,objAuthor.getName());
            objPrepare.setString(2,objAuthor.getNationality());
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
        //Convert the object
        Author objAuthor = (Author) obj;
        //Open connection
        Connection objConnection = ConfigDB.openConnection();
        //Create a state variable
        boolean idDelete = false;

        try {
            //Sql
            String sql  = "DELETE FROM author WHERE id = ?;";
            //Create the prepared statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Asign value
            objPrepare.setInt(1,objAuthor.getId());
            //Execute the query
            int totalRowAffected = objPrepare.executeUpdate();
            if(totalRowAffected > 0){
                idDelete = true;
                JOptionPane.showMessageDialog(null, "The delete was succesful");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //Close the connection
        ConfigDB.closeConnection();
        return idDelete;
    }

    public Author findById(int id) {
        //Open the connection
        Connection objConnection = ConfigDB.openConnection();
        //create author
        Author objAuthor = null;

        try {
            //Sql
            String sql = "SELECT * FROM coder WHERE id = ?;";
            //Create prepare statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Asign value
            objPrepare.setInt(1, id);
            //Execute query
            ResultSet objResult = objPrepare.executeQuery();
            if(objResult.next()){
                objAuthor = new Author();
                objAuthor.setName(objResult.getString("name"));
                objAuthor.setNationality(objResult.getString("nationality"));
                objAuthor.setId(objResult.getInt("id"));
        }
    }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //Close connection
        ConfigDB.closeConnection();
        return objAuthor;    
}
}
