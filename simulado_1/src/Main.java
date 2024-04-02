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
                       4.update patient  
                            """);
            switch (option){
                case"1":
                    PatientController.create();
                    break;
                case"2":
                    PatientController.getAll();
                    break;
                case"3":
                    PatientController.delete();
                    break;
                case"4":
                    PatientController.upDate();
                    break;
            }

        }while (!option.equals("6"));
    }
}