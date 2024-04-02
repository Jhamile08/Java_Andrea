package controller;

import entity.Medico;
import entity.Patient;
import entity.Specialty;
import model.MedicoModel;
import model.PatientModel;
import model.SpecialtyModel;

import javax.swing.*;
import java.util.List;

public class MedicoController {
    public static void create(){
        MedicoModel objMedicoModel = new MedicoModel();
        SpecialtyModel objSpecialtyModel = new SpecialtyModel();
        //Requist the data to the user
        String name = JOptionPane.showInputDialog("Insert de medico's name: ");
        String surname = JOptionPane.showInputDialog("Insert de medico's surname: ");
        List<Specialty> specialtyList = objSpecialtyModel.findAll();

        Object[] optionSpecialty = specialtyList.stream().map(Specialty::getName).toArray();
        String selectFilterPatient =
                (String) JOptionPane.showInputDialog(null, "Seleccione el paciente\n", "Filter", JOptionPane.QUESTION_MESSAGE, null, optionSpecialty, optionSpecialty[0]);
    }

}
