package controller;

import entity.Medico;
import Utils.Utils;
import entity.Specialty;
import model.MedicoModel;
import model.SpecialtyModel;

import javax.swing.*;


public class MedicoController {
    public static void create() {
        MedicoModel objMedicoModel = new MedicoModel();
        SpecialtyModel objSpecialtyModel = new SpecialtyModel();
        //Requist the data to the user
        String name = JOptionPane.showInputDialog("Insert de medico's name: ");
        String surname = JOptionPane.showInputDialog("Insert de medico's surname: ");
        Object[] options = Utils.listToArray(objSpecialtyModel.findAll());


        Specialty idSpecialty = (Specialty) JOptionPane.showInputDialog(null,
                "This are the specialities availible",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);


        //Create the instance
        Medico objMedico = new Medico();
        objMedico.setName(name);
        objMedico.setSurname(surname);
        objMedico.setId_specialty_foreing(idSpecialty.getId_specialty());
        objMedico = (Medico) objMedicoModel.insert(objMedico);
        JOptionPane.showMessageDialog(null,objMedico.toString());
    }

    public static void getAll() {
        MedicoModel objMedicoModel = new MedicoModel();
        String listMedico = "Medico list\n";
        for (Object iterator : objMedicoModel.findAll()) {
            //Convert the object to author
            Medico objMedico = (Medico) iterator;
            listMedico += objMedico.info() + "\n";
        }
        JOptionPane.showMessageDialog(null, listMedico);
    }

    public static String getAllString() {
        MedicoModel objModel = new MedicoModel();
        String listMedico = "Medico list\n";
        for (Object iterator : objModel.findAll()) {
            Medico objMedico = (Medico) iterator;
            listMedico += objMedico.toString() + "\n";
        }
        return listMedico;
    }

    public static void delete() {
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Medico objectSelected = (Medico) JOptionPane.showInputDialog(null,"Select one speciality",
               "",
               JOptionPane.QUESTION_MESSAGE,null,
               options, options[0]
       );
        int confirm = 1;
        if(objectSelected == null){
            JOptionPane.showMessageDialog(null, "Medic not found");
        }else{
            confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete medic?\n " + objectSelected.toString());
            if(confirm == 0) instanceModel().delete(objectSelected);
        }
    }

    public static void upDate() {
        Object[] options = Utils.listToArray(instanceModel().findAll());
        //Get the author = id
        Medico objMedico = (Medico) JOptionPane.showInputDialog(null,"Select the medic to edit",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                options, options[0]
        );

        //Validate to exists author
        if (objMedico == null) {
            JOptionPane.showMessageDialog(null, "Medico not found");
            return;
        }

        objMedico.setName(JOptionPane.showInputDialog(null, "Enter new name", objMedico.getName()));
        objMedico.setSurname(JOptionPane.showInputDialog(null, "Enter new surname: ", objMedico.getSurname()));
        objMedico.setId_specialty_foreing(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id specialty: ", objMedico.getId_specialty_foreing())));
        instanceModel().upDate(objMedico);

    }


    public static MedicoModel instanceModel() {
        return new MedicoModel();
    }

}
