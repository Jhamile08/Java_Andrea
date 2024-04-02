package controller;

import model.SpecialtyModel;

import javax.swing.*;

public class SpecialtyController {
    SpecialtyModel objSpeacialtyModel = new SpecialtyModel();

    //Requiest the data to the user
    String name = JOptionPane.showInputDialog("Insert specialty's name: ");
    String description = JOptionPane.showInputDialog("Insert the specialty's description: ");
}
