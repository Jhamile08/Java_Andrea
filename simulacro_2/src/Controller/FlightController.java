package Controller;

import Entity.Flight;
import Entity.Passenger;
import Entity.Plane;
import Model.FlightModel;
import Model.PlaneModel;
import Utils.Utils;

import javax.swing.*;

public class FlightController {
    public static void create() {
        String destination = JOptionPane.showInputDialog("Insert the flight destination: ");
        String year_date = JOptionPane.showInputDialog("Now insert the date, first insert the year(yyyy): ");
        String month_date = JOptionPane.showInputDialog("Insert the month(mm): ");
        String day_date = JOptionPane.showInputDialog("Insert the day(dd): ");
        String departure_date = year_date+"-"+month_date+"-"+day_date;
        String departure_time = JOptionPane.showInputDialog("Insert time: ");
        PlaneModel planeModel = new PlaneModel();
        Object[] option = Utils.listToArray(planeModel.findAll());
        Plane planeSelected = (Plane) JOptionPane.showInputDialog(null,"Select the plane",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );

        Flight instanceFlight = (Flight) instanceModel().insert(new Flight(destination, departure_date, departure_time,planeSelected.getId_plane()));
        JOptionPane.showMessageDialog(null, instanceFlight.info());
    }
    public static void getAll(){
        String listFlight = "Flight list\n";
        for(Object iterator : instanceModel().findAll()){
            Flight objFlight = (Flight) iterator;
            listFlight += objFlight.info() + "\n";
        }
        JOptionPane.showMessageDialog(null, listFlight);
    }
    public static void upDate(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Flight flightSelected = (Flight) JOptionPane.showInputDialog(null,"Select the flight to edit",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        if(flightSelected == null){
            JOptionPane.showMessageDialog(null, "Passenger not found");
        }
        flightSelected.setDestination(JOptionPane.showInputDialog(null,"Enter the new flight's destination: ", flightSelected.getDestination()));
        flightSelected.setDeparture_date(JOptionPane.showInputDialog(null, "Insert the new flight's departure date: ", flightSelected.getDeparture_date()));
        flightSelected.setDeparture_time(JOptionPane.showInputDialog(null, "Insert the new flight's departure time: ", flightSelected.getDeparture_time()));
        flightSelected.setId_plane(Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the new flight's departure time: ", flightSelected.getId_plane())));
        instanceModel().upDate(flightSelected);
    }
    public static void delete(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Flight flightSelected = (Flight) JOptionPane.showInputDialog(null,"Select the flight to delete",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        int confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete this flight?\n " + flightSelected.info());
        if(confirm == 0) instanceModel().delete(flightSelected);

    }
    public static FlightModel instanceModel(){
        return new FlightModel();
    }

}
