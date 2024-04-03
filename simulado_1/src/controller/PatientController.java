package controller;

import entity.Patient;
import model.PatientModel;

import javax.swing.*;
import java.util.Date;

public class PatientController {
    public static void create(){
        //Use model
        PatientModel objPatientModel = new PatientModel();

        //Requiest the data to the user
        String name = JOptionPane.showInputDialog("Insert patient's name: ");
        String surname = JOptionPane.showInputDialog("Insert patient's surnames: ");
        String birth_date = JOptionPane.showInputDialog("Insert the birth date (dd-mm-yyyy): ");
        String identity = JOptionPane.showInputDialog("Insert patient's identity: ");

        //Create the instance
        Patient objPatient = new Patient();
        objPatient.setName(name);
        objPatient.setSurname(surname);
        objPatient.setBirth_date(birth_date);
        objPatient.setIdentity(identity);

        //Call the method insert from patient  model and save the object
        objPatient = (Patient) objPatientModel.insert(objPatient);
        JOptionPane.showMessageDialog(null,objPatient.toString());
    }
    public static void getAll(){

        PatientModel objPatientModel = new PatientModel();
        String listPatient = "Patient list\n";
        for(Object iterador : objPatientModel.findAll()){
            //Convert the object to author
            Patient objPatient = (Patient) iterador;
            listPatient += objPatient.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null,listPatient);
    }

    public static String getAllString(){
        PatientModel objModel = new PatientModel();
        String listPatient = "Patient list\n";
        for(Object iterador : objModel.findAll()){
            //Convert the object to author
            Patient objBook = (Patient) iterador;
            listPatient += objBook.toString() + "\n";
        }
        return listPatient;
    }


    public static void delete(){
        PatientModel objPatientModel = new PatientModel();
        String listPatient = getAllString();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listPatient + "\n Enter the id patient to delete: "));
        Patient objPatient = (Patient) objPatientModel.findById(idDelete);
        int confirm = 1;
        if(objPatient == null){
            JOptionPane.showMessageDialog(null, "Patient not found");
        }else{
            confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete patient?\n " + objPatient.toString());
            if(confirm == 0) objPatientModel.delete(objPatient);
        }
    }

    public static void upDate(){
        PatientModel objPatientModel = new PatientModel();

        String listPatient = getAllString();
        int idUpDate = Integer.parseInt(JOptionPane.showInputDialog(listPatient+"\n Enter the patient ID to edit: "));
        //Get the patient id
        Patient objPatient = (Patient) objPatientModel.findById(idUpDate);

        //Validate to exists patient
        if(objPatient==null){
            JOptionPane.showMessageDialog(null, "Patient not found");
        } else {
            String name = JOptionPane.showInputDialog(null, "Enter new name: ", objPatient.getName());
            String surname = JOptionPane.showInputDialog(null, "Enter the new surname: ", objPatient.getSurname());
            String birth_date = JOptionPane.showInputDialog(null, "Enter the new birth: ", objPatient.getBirth_date());
            String identity = JOptionPane.showInputDialog(null, "Enter de new identity", objPatient.getIdentity());

            objPatient.setName(name);
            objPatient.setSurname(surname);
            objPatient.setBirth_date(birth_date);
            objPatient.setIdentity(identity);
            objPatientModel.upDate(objPatient);
        }
    }
}
