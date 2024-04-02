import controller.PatientController;
import controller.SpecialtyController;
import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ConfigDB.openConnection();

        String option = "";
        do{
            option = JOptionPane.showInputDialog(
                    """
                       1.patient
                       2.specialty     
                       3.medico  
                       4.appoitment
                       5.close
                            """);
            switch (option){
                case"1":
                    String option2 = "";
                    do{
                        option2 = JOptionPane.showInputDialog(
                                """
                                   1.create patient
                                   2.show patient       
                                   3.delete patient  
                                   4.update patient  
                                   5.back
                                        """);
                        switch (option2){
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

                    }while (!option2.equals("5"));
                    break;
                case"2":
                    String option3 = "";
                    do{
                        option3 = JOptionPane.showInputDialog(
                                """
                                   1.create specialty
                                   2.show specialty       
                                   3.delete specialty  
                                   4.update specialty  
                                   5.back
                                        """);
                        switch (option3){
                            case"1":
                                SpecialtyController.create();
                                break;
                            case"2":
                                SpecialtyController.getAll();
                                break;
                            case"3":
                                SpecialtyController.delete();
                                break;
                            case"4":
                                SpecialtyController.upDate();
                                break;
                        }

                    }while (!option3.equals("5"));
                    break;
                case"3":
                    String option4 = "";
                    do{
                        option3 = JOptionPane.showInputDialog(
                                """
                                   1.create specialty
                                   2.show specialty       
                                   3.delete specialty  
                                   4.update specialty  
                                   5.back
                                        """);
                        switch (option4){
                            case"1":
                                SpecialtyController.create();
                                break;
                            case"2":
                                SpecialtyController.getAll();
                                break;
                            case"3":
                                SpecialtyController.delete();
                                break;
                            case"4":
                                SpecialtyController.upDate();
                                break;
                        }

                    }while (!option4.equals("5"));
                    break;
                case"4":
                    PatientController.upDate();
                    break;
            }

        }while (!option.equals("6"));
    }
}