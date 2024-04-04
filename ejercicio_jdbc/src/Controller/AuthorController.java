package Controller;

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
        AuthorModel objModel = new AuthorModel();
        String listAuthors = "Author list\n";
        for(Object iterator : objModel.findAll()){
            //Convert the object to author
            Author objAuthor = (Author) iterator;
            listAuthors += objAuthor.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listAuthors);
    }

    public static String getAllString(){
        AuthorModel objModel = new AuthorModel();
        String listAuthors = "Author list\n";
        for(Object iterador : objModel.findAll()){
            //Convert the object to author
            Author objAuthor = (Author) iterador;
            listAuthors += objAuthor.toString() + "\n";
        }
        return listAuthors;
    }

    public static void delete(){
        AuthorModel objAuthorModel = new AuthorModel();
        String listAuthors = getAllString();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listAuthors + "\n Enter the id author to delete: "));
        Author objAuthor = objAuthorModel.findById(idDelete);
        int confirm = 1;
        if(objAuthor == null){
            JOptionPane.showMessageDialog(null, "Coder not found");
        }else{
            confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete author?\n " + objAuthor.toString());
            if(confirm == 0) objAuthorModel.delete(objAuthor);
        }
    }
// getByName
    public static void getById(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n Enter the id to find: "));
        AuthorModel objAuthorModel = new AuthorModel();

        String listaString = "the author with "+id+" is:\n";
        for(Author iterador: objAuthorModel.foundById(id)){
            listaString += iterador.toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, listaString);

    }
    public static void upDate(){
        //Use the model
        AuthorModel objAuthorModel = new AuthorModel();

        String listAuthors = getAllString();
        int idUpDate = Integer.parseInt(JOptionPane.showInputDialog(listAuthors+"\n Enter the author ID to edit: "));
        //Get the author = id
        Author objAuthor = objAuthorModel.findById(idUpDate);

        //Validate to exists author
        if(objAuthor == null){
            JOptionPane.showMessageDialog(null, "Author not found");
        }else {
            String name = JOptionPane.showInputDialog(null,"Enter new name", objAuthor.getName());
            String nationality = JOptionPane.showInputDialog(null, "Enter new nationality: ", objAuthor.getNationality());

            objAuthor.setName(name);
            objAuthor.setNationality(nationality);
            objAuthorModel.upDate(objAuthor);
        }
    }
}