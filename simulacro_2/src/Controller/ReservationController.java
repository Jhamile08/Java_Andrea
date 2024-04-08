package Controller;

import Entity.Flight;
import Entity.Passenger;
import Entity.Plane;
import Entity.Reservation;
import Model.FlightModel;
import Model.PassengerModel;
import Model.PlaneModel;
import Model.ReservationModel;
import Utils.Utils;

import javax.swing.*;

public class ReservationController {
    public static void create(){
        ReservationModel objReservation = new ReservationModel();
        PassengerModel objPassengerModel = new PassengerModel();
        FlightModel objFlightModel = new FlightModel();
    String reservation_time = JOptionPane.showInputDialog("Insert the reservation date(yyyy:mm:dd): ");
        Flight flightSelected;
   do {
       Object[] option2 = Utils.listToArray(objFlightModel.findAll());
        flightSelected = (Flight) JOptionPane.showInputDialog(null, "Select the flight for this reservation: ",
               "",
               JOptionPane.QUESTION_MESSAGE, null,
               option2, option2[0]
       );
       if (flightSelected == null) {
           //If the user cancel the flight
           break;
       }

       boolean reservationValid = objReservation.verifyCapacity(flightSelected.getId_flight());
       if (!reservationValid) {
           flightSelected = null;
       }
   } while(flightSelected == null);
        if (flightSelected != null) {
            String seat = JOptionPane.showInputDialog("Insert the seat: ");

            Object[] option = Utils.listToArray(objPassengerModel.findAll());
            Passenger passengerSelected = (Passenger) JOptionPane.showInputDialog(null, "Select the passenger for this reservation: ",
                    "",
                    JOptionPane.QUESTION_MESSAGE, null,
                    option, option[0]
            );

            Reservation instanceReservation = (Reservation) instanceModel().insert(new Reservation(reservation_time, seat, passengerSelected.getId_passenger(), flightSelected.getId_flight()));
            JOptionPane.showMessageDialog(null, instanceReservation.info());
        }
}
    public static void getAll(){
        String listReservation = "Reservation list\n";
        for(Object iterator : instanceModel().findAll()){
            Reservation objReservation = (Reservation) iterator;
            listReservation += objReservation.info() + "\n";
        }
        JOptionPane.showMessageDialog(null, listReservation);
    }
    public static void upDate(){
        PassengerModel objPassengerModel = new PassengerModel();
        FlightModel objFlightModel = new FlightModel();
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Reservation reservationSelected = (Reservation) JOptionPane.showInputDialog(null,"Select the reservation to edit",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        if(reservationSelected == null){
            JOptionPane.showMessageDialog(null, "Plane not found");
        }
        reservationSelected.setReservation_time(JOptionPane.showInputDialog(null, "Enter the new reservation time: ", reservationSelected.getReservation_time()));
        reservationSelected.setSeat(JOptionPane.showInputDialog(null, "Enter the new seat: ", reservationSelected.getSeat()));
        Object[] option2 = Utils.listToArray(objPassengerModel.findAll());
        Passenger passengerSelected = (Passenger) JOptionPane.showInputDialog(null,"Select the new passenger for this reservation: ",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option2, option2[0]
        );
        Object[] option3 = Utils.listToArray(objFlightModel.findAll());
        Flight flightSelected = (Flight) JOptionPane.showInputDialog(null,"Select the flight for this reservation: ",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option3, option3[0]
        );
        instanceModel().upDate(reservationSelected);
    }
    public static void delete(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Reservation reservationSelected = (Reservation) JOptionPane.showInputDialog(null,"Select the reservation to delete",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );

        int confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete this reservation?\n " + reservationSelected.toString());
        if(confirm == 0) instanceModel().delete(reservationSelected);

    }
    public static ReservationModel instanceModel(){ return new ReservationModel();}
}
