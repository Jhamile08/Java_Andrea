
import controller.coderController;
import database.ConfigDB;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    1. List Coders.
                    2. Insert Coder.
                    3. Update Coder.
                    4. Delete Coder.
                    5. Get coder by name.
                    6. Exit
                    
                    Choose an option:
                    """);
            switch (option){
                case "1":
                    coderController.getAll();
                    break;
                case "2":
                    coderController.create();
                    break;
                case "4":
                    coderController.delete();
                    break;
                case "5":
                    coderController.getByName();
                    break;
            }
        }while(!option.equals("6"));

    }
}