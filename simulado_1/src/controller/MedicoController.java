package controller;

import entity.Medico;
import entity.Patient;
import model.MedicoModel;
import model.PatientModel;

import javax.swing.*;
import java.util.List;

public class MedicoController {
    public static void create(){
        MedicoModel objMedicoModel = new MedicoModel();
        PatientModel objPatientModel = new PatientModel();

        //Requist the data to the user
        String name = JOptionPane.showInputDialog("Insert de medico's name: ");
        String surname = JOptionPane.showInputDialog("Insert de medico's surname: ");
        List<Patient> patientList = objPatientModel.findAll();

        Object[] optionsPatient = patientList.stream().map(Patient::getName).toArray();
        String selectFilterPatient =
                (String) JOptionPane.showInputDialog(null, "Seleccione el paciente\n", "Filter", JOptionPane.QUESTION_MESSAGE, null, optionsPatient, optionsPatient[0]);
    }
}
