import controller.PatientController;
import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ConfigDB.openConnection();

        String option = "";
        do{
            option = JOptionPane.showInputDialog(
                    """
                       1.create patient
                       2.show patient       
                       3.delete patient  
                            """);
            switch (option){
                case"1":
                    PatientController.create();
                case"2":
                    PatientController.getAll();
                case"3":
                    PatientController.delete();
            }

        }while (!option.equals("6"));
    }
}