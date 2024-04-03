package controller;

import entity.Medico;
import entity.MedicoAdapter;
import entity.Patient;
import entity.Specialty;
import model.MedicoModel;
import model.PatientModel;
import model.SpecialtyModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MedicoController {
    public static void create() {
        MedicoModel objMedicoModel = new MedicoModel();
        SpecialtyModel objSpecialtyModel = new SpecialtyModel();
        //Requist the data to the user
        String name = JOptionPane.showInputDialog("Insert de medico's name: ");
        String surname = JOptionPane.showInputDialog("Insert de medico's surname: ");
        List<Object> listSpecialty = objSpecialtyModel.findAll();
        Specialty[] arrSpecialty = new Specialty[listSpecialty.size()];

        int i = 0;
        for (Object iterator : listSpecialty){
            Specialty objSpecialty = (Specialty) iterator;
            arrSpecialty[i] = objSpecialty;
            i++;
        }

        Specialty idSpecialty = (Specialty) JOptionPane.showInputDialog(null,
                "This are the specialities availible",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                arrSpecialty,
                arrSpecialty[0]);


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
            listMedico += objMedico.toString() + "\n";
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



    }

    public static void upDate() {

        List<Object> listSpecialty = instanceModel().findAll();
        listToArrayMedic(listSpecialty);
        //Get the author = id
        Medico objMedico = instanceModel().findById(input.getObjMedico().getId_medico());

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

    public static Medico[] listToArrayMedic(List<Object> listMedicos){
        Medico[] arrMedico = new Medico[listMedicos.size()];
        int i = 0;
        for (Object iterator : listMedicos) {
            Medico objMedico = (Medico) iterator;
            arrMedico[i] = objMedico;
            i++;
        }
        return arrMedico;

    }


    public static MedicoModel instanceModel() {
        return new MedicoModel();
    }

}
