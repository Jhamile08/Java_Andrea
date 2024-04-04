package Controller;

import Entity.Plane;
import Model.PlaneModel;

import javax.swing.*;

public class PlaneController {
    public static void create(){
        String model = JOptionPane.showInputDialog("Insert the plane model: ");
        int capacity = Integer.parseInt(JOptionPane.showInputDialog("What is the plane capacity: "));

        Plane instancePlane = (Plane) instanceModel().insert(new Plane(model,capacity));
        JOptionPane.showMessageDialog(null,instancePlane.info());

    }
    public static PlaneModel instanceModel(){ return new PlaneModel();}
}
