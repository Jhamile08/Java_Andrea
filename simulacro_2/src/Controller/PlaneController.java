package Controller;

import Entity.Plane;
import Model.PlaneModel;
import Utils.Utils;

import javax.swing.*;

public class PlaneController {
    public static void create(){
        String model = JOptionPane.showInputDialog("Insert the plane model: ");
        int capacity = Integer.parseInt(JOptionPane.showInputDialog("What is the plane capacity: "));

        Plane instancePlane = (Plane) instanceModel().insert(new Plane(model,capacity));
        JOptionPane.showMessageDialog(null,instancePlane.info());

    }

    public static void getAll(){
        String listPane = "Plane list\n";
        for(Object iterator : instanceModel().findAll()){
            Plane objPlane = (Plane) iterator;
            listPane += objPlane.info() + "\n";
        }
        JOptionPane.showMessageDialog(null, listPane);
    }

    public static void upDate(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Plane planeSelected = (Plane) JOptionPane.showInputDialog(null,"Select the plane to edit",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        if(planeSelected == null){
            JOptionPane.showMessageDialog(null, "Plane not found");
        }
        planeSelected.setModel(JOptionPane.showInputDialog(null, "Enter the new model: ", planeSelected.getModel()));
        planeSelected.setCapacity(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the new capacity: ", planeSelected.getCapacity())));
        instanceModel().upDate(planeSelected);
    }

    public static void delete(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Plane planeSelected = (Plane) JOptionPane.showInputDialog(null,"Select the plane to delete",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );

        int confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete this plane?\n " + planeSelected.toString());
        if(confirm == 0) instanceModel().delete(planeSelected);

    }

    public static PlaneModel instanceModel(){ return new PlaneModel();}
}
