package controller;

import database.ConfigDB;
import entity.Author;
import entity.Book;
import model.AuthorModel;
import model.BookModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookController{
    public static void create(){
        //Use the model
        BookModel objBookModel = new BookModel();

        //Requiest the data to the user
        String title = JOptionPane.showInputDialog("Insert book title: ");
        String year_publication = JOptionPane.showInputDialog("Insert the year publication: ");
        String pice = JOptionPane.showInputDialog("Insert the price: ");
        String id_author = JOptionPane.showInputDialog("Insert the id author: ");

        //Create the instance
        Book objBook = new Book();
        objBook.setTitle(title);
        objBook.setYear_publication(Integer.parseInt(year_publication));
        objBook.setPrice(Double.parseDouble(pice));
        objBook.setId_author(Integer.parseInt(id_author));

        //Call the method insert and save the object
        objBook = (Book) objBookModel.insert(objBook);
        JOptionPane.showMessageDialog(null, objBook.toString());
    }
    public static void getAll(){

        BookModel objBook = new BookModel();
        String listCoders = "coder list\n";
        for(Object iterador : objBook.findAll()){
            //Convert the object to author
            Book objCoder = (Book) iterador;
            listCoders += objCoder.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null,listCoders);
    }

    public static String getAllString(){
        BookModel objModel = new BookModel();
        String listBooks = "books list\n";
        for(Object iterador : objModel.findAll()){
            //Convert the object to author
            Book objBook = (Book) iterador;
            listBooks += objBook.toString() + "\n";
        }
        return listBooks;
    }

    public static void delete(){
        BookModel objBookModel = new BookModel();
        String listBooks = getAllString();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listBooks + "\n Enter the id book to delete: "));
        Book objBook = objBookModel.findById(idDelete);
        int confirm = 1;
        if(objBook == null){
            JOptionPane.showMessageDialog(null, "Book not found");
        }else{
            confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete book?\n " + objBook.toString());
            if(confirm == 0) objBookModel.delete(objBook);
        }
    }

}
