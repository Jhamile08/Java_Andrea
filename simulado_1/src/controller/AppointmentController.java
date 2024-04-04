package controller;

import Utils.Utils;
import entity.Medico;
import entity.Patient;
import entity.Specialty;
import model.AppointmentModel;
import model.MedicoModel;
import model.PatientModel;
import model.SpecialtyModel;

import javax.swing.*;

public class AppointmentController {
    public static void create() {
        MedicoModel objMedicoModel = new MedicoModel();
        PatientModel objPatientModel = new PatientModel();
        //Requist the data to the user
        Object[] optionMedico = Utils.listToArray(objMedicoModel.findAll());
        Medico medicoSelected = (Medico) JOptionPane.showInputDialog(null,
                "This are the medicos availible",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionMedico,
                optionMedico[0]);

        Object[] optionPatient = Utils.listToArray(objPatientModel.findAll());
        Patient patientSelected = (Patient) JOptionPane.showInputDialog(null,
                "This are the patients availible",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionPatient,
                optionPatient[0]);


        //Create the instance
        Medico objMedico = new Medico();
        objMedico = (Medico) objMedicoModel.insert(optionMedico,optionPatient,);
        JOptionPane.showMessageDialog(null,objMedico.toString());
    }

    public static AppointmentModel instanceAppointment() {
        return new AppointmentModel();
    }

}
