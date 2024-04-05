

import Controller.FlightController;
import Controller.PassengerController;
import Controller.ReservationController;
import DataBase.ConfigDB;
import Controller.PlaneController;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ConfigDB.openConnection();

        String option = "";
        do{
            option = JOptionPane.showInputDialog(
                    """
                       Welcome to the hospital
                       
                       1.Consult planes
                       2.Consult passengers    
                       3.Consult flights  
                       4.Consult reservations
                       5.close
                            """);
            switch (option){
                case"1":
                    String option2 = "";
                    do{
                        option2 = JOptionPane.showInputDialog(
                                """ 
                                      PLANE
                                       
                                       1. Create plane
                                       2. Show plane       
                                       3. Delete plane  
                                       4. Update plane  
                                       5. Back
                                       
                                            """);
                        switch (option2){
                            case"1":
                                PlaneController.create();
                                break;
                            case"2":
                                PlaneController.getAll();
                                break;
                            case"3":
                                PlaneController.delete();
                                break;
                            case"4":
                                PlaneController.upDate();
                                break;
                        }

                    }while (!option2.equals("5"));
                    break;
                case"2":
                    String option3 = "";
                    do{
                        option3 = JOptionPane.showInputDialog(
                                """
                                   PASSENGERS
                                   
                                   1. Create passenger
                                   2. Show passenger       
                                   3. Delete passenger  
                                   4. Update passenger  
                                   5. Back
                                   
                                        """);
                        switch (option3){
                            case"1":
                                PassengerController.create();
                                break;
                            case"2":
                                PassengerController.getAll();
                                break;
                            case"3":
                                PassengerController.delete();
                                break;
                            case"4":
                                PassengerController.upDate();
                                break;
                        }

                    }while (!option3.equals("5"));
                    break;
                case"3":
                    String option4 = "";
                    do{
                        option4 = JOptionPane.showInputDialog(
                                """
                                   FLIGHT
                                   
                                   1. Create flight
                                   2. Show flight       
                                   3. Delete flight  
                                   4. Update flight  
                                   5. Back
                                   
                                        """);
                        switch (option4){
                            case"1":
                                FlightController.create();
                                break;
                            case"2":
                                FlightController.getAll();
                                break;
                            case"3":
                                FlightController.delete();
                                break;
                            case"4":
                                FlightController.upDate();
                                break;
                        }

                    }while (!option4.equals("5"));
                    break;
                case"4":
                    String option5 = "";
                    do{
                        option5 = JOptionPane.showInputDialog(
                                """
                                   RESERVATIONS
                                   
                                   1. Create reservation
                                   2. Show reservation       
                                   3. Delete reservation  
                                   4. Update reservation  
                                   5. Back
                                   
                                        """);
                        switch (option5){
                            case"1":
                                ReservationController.create();
                                break;
                            case"2":
                                ReservationController.getAll();
                                break;
                            case"3":
                                ReservationController.delete();
                                break;
                            case"4":
                                ReservationController.upDate();
                                break;
                        }

                    }while (!option5.equals("5"));
                    break;

            }

        }while (!option.equals("5"));
    }
}