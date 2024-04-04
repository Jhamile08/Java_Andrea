package Controller;

import entity.Specialty;
import model.SpecialtyModel;

import javax.swing.*;

public class SpecialtyController {
    public static void create(){
        SpecialtyModel objSpeacialtyModel = new SpecialtyModel();

        //Requiest the data to the user
        String name = JOptionPane.showInputDialog("Insert specialty's name: ");
        String description = JOptionPane.showInputDialog("Insert the specialty's description: ");

        //Create instansce
        Specialty objSpecialty = new Specialty();
        objSpecialty.setName(name);
        objSpecialty.setDescription(description);

        //Call the method insert and save the object
        objSpecialty = (Specialty) objSpeacialtyModel.insert(objSpecialty);
        JOptionPane.showMessageDialog(null, objSpecialty.info());
    }

    public static void getAll(){
        SpecialtyModel objModel = new SpecialtyModel();
        String listSpecialty = "Specialty list\n";
        for(Object iterador: objModel.findAll()){
            Specialty objSpecialty = (Specialty) iterador;
            listSpecialty += objSpecialty.info() + "\n";
        }
        JOptionPane.showMessageDialog(null, listSpecialty);
    }

    public static String getAllString(){
        SpecialtyModel objModel = new SpecialtyModel();
        String listSpecialty = "Specialty list\n";

        for(Object iterador: objModel.findAll()){
            Specialty objSpecialty = (Specialty) iterador;
            listSpecialty += objSpecialty.info() + "\n";
        }
        return listSpecialty;
    }


    public static void upDate(){
        SpecialtyModel objSpecialtyModel = new SpecialtyModel();

        String listSpecialty = getAllString();
        int isUpDate = Integer.parseInt(JOptionPane.showInputDialog(listSpecialty+"\n Enter the specialty id to edit: "));
        Specialty objSpecialty = objSpecialtyModel.findById(isUpDate);

        //Validate to exists specialty
        if(objSpecialty == null){
            JOptionPane.showMessageDialog(null, "Spealty not found");
        }else {
            String name = JOptionPane.showInputDialog(null, "Enter the new specialty's name: ", objSpecialty.getName());
            String description = JOptionPane.showInputDialog(null, "Enter the new specialty's description: ", objSpecialty.getDescription());

            objSpecialty.setName(name);
            objSpecialty.setDescription(description);
            objSpecialtyModel.upDate(objSpecialty);
        }

    }
    public static void delete(){
        SpecialtyModel objSpecialtyModel = new SpecialtyModel();
        String listSpecialty = getAllString();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listSpecialty + "\n Enter the specialty id to delete: "));
        Specialty objSpecialty = objSpecialtyModel.findById(idDelete);
        int confirm = 1;
        if(objSpecialty == null){
            JOptionPane.showMessageDialog(null, "Specialty not found");
        }else{
            confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete specialty?\n " + objSpecialty.info());
            if(confirm == 0) objSpecialtyModel.delete(objSpecialty);
        }
    }
}
