package model;

import database.CRUD;
import database.ConfigDB;
import entity.Author;
import entity.Book;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        //Open connection
        Connection objConnection = ConfigDB.openConnection();
        //Convert object
        Book objBook = (Book) obj;
        try {
            //SQL
            String sql = "INSERT INTO book (title,year_publication,price,id_author) VALUES (?,?,?,?);";
            //Prepare statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //Asign value to the ??
            objPrepare.setString(1, objBook.getTitle());
            objPrepare.setInt(2, objBook.getYear_publication());
            objPrepare.setDouble(3, objBook.getPrice());
            objPrepare.setInt(4, objBook.getId_author());
            //Excecute query
            objPrepare.execute();
            //Get the result with the id
            ResultSet objRest = objPrepare.getGeneratedKeys();
            //While book exists
            while (objRest.next()) {
                //get the value with the index
                objBook.setId(objRest.getInt(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());

        }
        return objBook;
    }

    @Override
    public List<Object> findAll() {
        //Create list
        List<Object> listBooks = new ArrayList<>();
        //Open connection
        Connection objConnection = ConfigDB.openConnection();

        try{
            //SQL
            String sql = "SELECT * FROM book;";
            //Use the preparateStatement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Execute query and get the result
            ResultSet objResult = objPrepare.executeQuery();
            //While exists an author
            while (objResult.next()) {
                Book objBook = new Book();
                objBook.setId(objResult.getInt("id"));
                objBook.setTitle(objResult.getString("title"));
                objBook.setYear_publication(objResult.getInt("year_publication"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setId_author(objResult.getInt("id_author"));
                listBooks.add(objBook);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //Close the connection
        ConfigDB.closeConnection();
        return listBooks;
    }


    @Override
    public boolean upDate(Object obj) {
        //Open connection
        Connection objConnection = ConfigDB.openConnection();
        //Convert to author
        Book objBook = (Book) obj;
        //Create a varible for know the state
        boolean isUpdate = false;
        try {
            //SQL
            String sql = "UPDATE book SET title = ?, year_publication = ?, price = ?, id_author = ? WHERE id = ?;";
            //Create prepared statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Asign value to the query
            objPrepare.setString(1, objBook.getTitle());
            objPrepare.setInt(2, objBook.getYear_publication());
            objPrepare.setDouble(3, objBook.getPrice());
            objPrepare.setInt(4, objBook.getId_author());
            objPrepare.setInt(5, objBook.getId());
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
        Book objBook = (Book) obj;
        //Open connection
        Connection objConnection = ConfigDB.openConnection();
        //Create a state variable
        boolean idDelete = false;

        try {
            //Sql
            String sql  = "DELETE FROM book WHERE id = ?;";
            //Create the prepared statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Asign value
            objPrepare.setInt(1,objBook.getId());
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
    public Book findById(int id) {
        //Open the connection
        Connection objConnection = ConfigDB.openConnection();
        //create book
        Book objBook = null;

        try {
            //Sql
            String sql = "SELECT * FROM book WHERE id = ?;";
            //Create prepare statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Asign value
            objPrepare.setInt(1, id);
            //Execute query
            ResultSet objResult = objPrepare.executeQuery();
            if(objResult.next()){
                objBook = new Book();
                objBook.setTitle(objResult.getString("title"));
                objBook.setYear_publication(objResult.getInt("year_publication"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setId_author(objResult.getInt("id_author"));
                objBook.setId(objResult.getInt("id"));
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //Close connection
        ConfigDB.closeConnection();

        return objBook;
    }

    //Found book by id
    public List<Book> foundById(int id){
        //se crea la lista
        List<Book> listBooks = new ArrayList<>();
        //abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();


        try {
            // Sentencia sql
            String sql = "SELECT * FROM book WHERE id like ?;";
            // Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            // valor al parametro
            objPrepare.setInt(1, id);
            //Ejecutamos el Query
            ResultSet objResult = objPrepare.executeQuery();

            while(objResult.next()) {
                Book objBook = new Book();
                objBook.setTitle(objResult.getString("title"));
                objBook.setYear_publication(objResult.getInt("year_publication"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setId_author(objResult.getInt("id_author"));
                objBook.setId(objResult.getInt("id"));

                listBooks.add(objBook);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        // Cerrar la conexion
        ConfigDB.closeConnection();
        return listBooks;
    }
    public List<Book> foundByName(String name){
        //se crea la lista
        List<Book> listBooks = new ArrayList<>();
        //abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();


        try {
            // Sentencia sql
            String sql = "SELECT * FROM book WHERE title like ?;";
            // Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            // valor al parametro
            objPrepare.setString(1, "%"+name+"%");
            //Ejecutamos el Query
            ResultSet objResult = objPrepare.executeQuery();

            while(objResult.next()) {
                Book objBook = new Book();
                objBook.setTitle(objResult.getString("title"));
                objBook.setYear_publication(objResult.getInt("year_publication"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setId_author(objResult.getInt("id_author"));
                objBook.setId(objResult.getInt("id"));

                listBooks.add(objBook);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        // Cerrar la conexion
        ConfigDB.closeConnection();
        return listBooks;
    }

    public List<Book> foundByAuthor(String nameAuthor){
        //se crea la lista
        List<Book> listBooks = new ArrayList<>();
        //abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();


        try {
            // Sentencia sql
            String sql = "SELECT * FROM book LEFT JOIN author ON book.id_author = author.id WHERE author.name = ? OR book.id_author = author.id;";
            // Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            // valor al parametro
            objPrepare.setString(1, "%"+nameAuthor+"%");
            //Ejecutamos el Query
            ResultSet objResult = objPrepare.executeQuery();

            while(objResult.next()) {
                Book objBook = new Book();
                objBook.setTitle(objResult.getString("title"));
                objBook.setYear_publication(objResult.getInt("year_publication"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setId_author(objResult.getInt("id_author"));
                objBook.setId(objResult.getInt("id"));

                listBooks.add(objBook);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        // Cerrar la conexion
        ConfigDB.closeConnection();
        return listBooks;
    }

}
