import controller.MedicoController;
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
                       Welcome to the hospital
                       
                       1.Consult patients
                       2.Consult specialties     
                       3.Consult medicos  
                       4.Consult appoitments
                       5.close
                            """);
            switch (option){
                case"1":
                    String option2 = "";
                    do{
                        option2 = JOptionPane.showInputDialog(
                            """ 
                                  PATIENT
                                   
                                   1. Create patient
                                   2. Show patient       
                                   3. Delete patient  
                                   4. Update patient  
                                   5. Back
                                   
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
                                   SPECIALTY
                                   
                                   1. Create specialty
                                   2. Show specialty       
                                   3. Delete specialty  
                                   4. Update specialty  
                                   5. Back
                                   
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
                        option4 = JOptionPane.showInputDialog(
                                """
                                   MEDICO
                                   
                                   1. Create medico
                                   2. Show medico       
                                   3. Delete medico  
                                   4. Update specialty  
                                   5. Back
                                   
                                        """);
                        switch (option4){
                            case"1":
                                MedicoController.create();
                                break;
                            case"2":
                                MedicoController.getAll();
                                break;
                            case"3":
                                MedicoController.delete();
                                break;
                            case"4":
                                MedicoController.upDate();
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