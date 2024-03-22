
import controller.AuthorController;
import controller.BookController;
import database.ConfigDB;
import entity.Author;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        ConfigDB.openConnection();

        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    1. Create a new author
                    2. Show all authors
                    3. Search author by id
                    4. Delete Author.
                    5. Modify author
                    6. Menu books
                    7. Exit
                    
                    
                    Choose an option:
                    """);
            switch (option){
                case "1":
                    AuthorController.create();
                    break;
                case "2":
                    AuthorController.getAll();
                    break;
                case "3":
                    AuthorController.getById();
                    break;
                case "4":
                    AuthorController.delete();
                    break;
                case "5":
                    AuthorController.upDate();
                    break;
                case "6":

                    String option2 = "";
                    do {
                        option2 = JOptionPane.showInputDialog("""
                    1. Create a new book
                    2. Show all books
                    3. Search books by id
                    4. Search books by title
                    5. Search books by author
                    6. Delete books.
                    7. Modify books         
                    8. Exit
                    
                    
                    Choose an option:
                    """);
                        switch (option2){
                            case "1":
                                BookController.create();
                            break;
                            case "2":
                                BookController.getAll();
                                break;
                            case "3":
                                BookController.getById();
                                break;
                            case "4":
                                BookController.getByName();
                                break;
                            case "6":
                                BookController.delete();
                                break;
                            case "7":
                                BookController.upDate();
                                break;
                        }
                    }while(!option.equals("6"));

            }
        }while(!option.equals("7"));

    }
}