package Controller;

import DataBase.CRUD;
import Entity.Passenger;
import Model.PassengerModel;
import Utils.Utils;

import javax.swing.*;
import java.awt.event.WindowStateListener;
import java.util.List;

public class PassengerController{
    public static void create(){
        String name = JOptionPane.showInputDialog("Insert the passenger's name: ");
        String surname = JOptionPane.showInputDialog("Insert the passenger's surname: ");
        String identity = JOptionPane.showInputDialog("Insert the passenger's identity: ");

        Passenger instancePlane = (Passenger) instanceModel().insert(new Passenger(name,surname,identity));
        JOptionPane.showMessageDialog(null, instancePlane.info());
    }

    public static void getAll(){
        String listPassenger = "Passenger list\n";
        for(Object iterator : instanceModel().findAll()){
            Passenger objPassenger = (Passenger) iterator;
            listPassenger += objPassenger.info() + "\n";
        }
        JOptionPane.showMessageDialog(null, listPassenger);
    }
    public static void upDate(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Passenger passengerSelected = (Passenger) JOptionPane.showInputDialog(null,"Select the passenger to edit",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        if(passengerSelected == null){
            JOptionPane.showMessageDialog(null, "Passenger not found");
        }
        passengerSelected.setName(JOptionPane.showInputDialog(null,"Enter the new passenger's name: ", passengerSelected.getName()));
        passengerSelected.setSurname(JOptionPane.showInputDialog(null, "Insert the new passenger's surname: ", passengerSelected.getSurname()));
        instanceModel().upDate(passengerSelected);
    }
    public static void delete(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Passenger passengerSelected = (Passenger) JOptionPane.showInputDialog(null,"Select the passenger to delete",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        int confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete this passenger?\n " + passengerSelected.info());
        if(confirm == 0) instanceModel().delete(passengerSelected);

    }
    public static PassengerModel instanceModel(){ return new PassengerModel();}

}
