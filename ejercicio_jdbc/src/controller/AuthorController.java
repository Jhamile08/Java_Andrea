package controller;

import entity.Author;
import model.AuthorModel;

import javax.swing.*;

public class AuthorController {
    public static void create(){
        //Use the model
        AuthorModel objAuthorModel = new AuthorModel();

        //Requiest the data to the user
        String name = JOptionPane.showInputDialog("Insert name: ");
        String nationality = JOptionPane.showInputDialog("Insert nationality: ");

        //Create the instance
        Author objAuthor = new Author();
        objAuthor.setName(name);
        objAuthor.setNationality(nationality);

        //Call the method insert and save the object
        objAuthor = (Author) objAuthorModel.insert(objAuthor);
        JOptionPane.showMessageDialog(null, objAuthor.toString());
    }

    public static void getAll(){
        AuthorModel objAuthorModel = new AuthorModel();
        String listAuthors = "Author list\n";
        for(Object iterator : objAuthorModel.findAll()){
            //Convert the object to author
            Author objAuthor = (Author) iterator;
            listAuthors += objAuthorModel.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listAuthors);
    }

    public static String getAllString(){
        AuthorModel objModel = new AuthorModel();
        String listAuthors = "coder list\n";
        for(Object iterador : objModel.findAll()){
            //Convertimos del object a coder
            Author objCoder = (Author) iterador;
            listAuthors += objCoder.toString() + "\n";
        }
        return listAuthors;
    }

    public static void delete(){
        AuthorModel objAuthorModel = new AuthorModel();
        String listAuthors = getAllString();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listAuthors + "\n Enter the id author to delete: "))
        Author objAuthor = objAuthorModel.f
    }
}