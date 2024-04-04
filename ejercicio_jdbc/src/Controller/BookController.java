package Controller;

import entity.Book;
import model.BookModel;

import javax.swing.*;

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

        BookModel objBookModel = new BookModel();
        String listBook = "Book list\n";
        for(Object iterator : objBookModel.findAll()){
            //Convert the object to author
            Book objBook = (Book) iterator;
            listBook += objBook.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null,listBook);
    }

    public static String getAllString(){
        BookModel objModel = new BookModel();
        String listBooks = "Books list\n";
        for(Object iterator : objModel.findAll()){
            //Convert the object to author
            Book objBook = (Book) iterator;
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

    public static void getById(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("\n Enter the book id to find: "));
        BookModel objBookModel = new BookModel();

        String listaString = "The book with id "+id+" is:\n";
        for(Book iterador: objBookModel.foundById(id)){
            listaString += iterador.toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, listaString);

    }
    public static void getByName(){
        String name = JOptionPane.showInputDialog("\n Enter the book name to find: ");
        BookModel objBookModel = new BookModel();

        String listaString = "The book with name "+name+" is:\n";
        for(Book iterador: objBookModel.foundByName(name)){
            listaString += iterador.toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, listaString);

    }
    public static void getByNameAuthor(){
        String nameAuthor = JOptionPane.showInputDialog("\n Enter the author name to find: ");
        BookModel objBookModel = new BookModel();

        String listaString = "The author book with name "+nameAuthor+" is:\n";
        for(Book iterador: objBookModel.foundByAuthor(nameAuthor)){
            listaString += iterador.toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, listaString);

    }

    public static void upDate(){
        //Use the model
        BookModel objBookModel = new BookModel();

        String listAuthors = getAllString();
        int idUpDate = Integer.parseInt(JOptionPane.showInputDialog(listAuthors+"\n Enter the Book ID to edit: "));
        //Get the author = id
        Book objBook = objBookModel.findById(idUpDate);

        //Validate to exists author
        if(objBook== null){
            JOptionPane.showMessageDialog(null, "Book not found");
        }else {
            String title = JOptionPane.showInputDialog(null,"Enter new title", objBook.getTitle());
            int year_publication = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter new publication year: ", objBook.getYear_publication()));
            double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter new price: ", objBook.getPrice()));
            int id_author = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter new book author  id: ", objBook.getId_author()));

            objBook.setTitle(title);
            objBook.setYear_publication(year_publication);
            objBook. setPrice(price);
            objBook.setId_author(id_author);
            objBookModel.upDate(objBook);
        }
    }


}
