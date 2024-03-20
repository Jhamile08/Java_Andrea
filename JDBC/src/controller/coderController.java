package controller;

import entity.Coder;
import model.CoderModel;
import javax.swing.*;
import java.util.List;

public class coderController {
    public static void getAll(){

        CoderModel objModel = new CoderModel();
        String listCoders = "coder list\n";
        for(Object iterador : objModel.findAll()){
            //Convertimos del object a coder
            Coder objCoder = (Coder) iterador;
            listCoders += objCoder.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null,listCoders);
    }

    public static String getAllString(){
        CoderModel objModel = new CoderModel();
        String listCoders = "coder list\n";
        for(Object iterador : objModel.findAll()){
            //Convertimos del object a coder
            Coder objCoder = (Coder) iterador;
            listCoders += objCoder.toString() + "\n";
        }
        return listCoders;
    }
    public static void create(){
        // Usamos el modelo
        CoderModel objCoderModel = new CoderModel();

        // Pedimos los datos al usuario
        String name = JOptionPane.showInputDialog("Insert name");
        String clan = JOptionPane.showInputDialog("Insert clan");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Insert age"));

        // Creamos la instancia de coder
        Coder objCoder = new Coder();
        objCoder.setClan(clan);
        objCoder.setAge(age);
        objCoder.setName(name);

        //Llamamos el metodo inserccion y guardamos el objeto que retorna en coder previamente instanciado,
        // debemos castearlo
        objCoder = (Coder) objCoderModel.insert(objCoder);
        JOptionPane.showMessageDialog(null, objCoder.toString());
    }

    public static void delete(){
        CoderModel objCoderModel = new CoderModel();
        String listCoders = getAllString();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listCoders + "\n Enter  the id to delete: "));
        Coder objCoder =  objCoderModel.findById(idDelete);
        int confirm = 1;
        if(objCoder == null){
            JOptionPane.showMessageDialog(null, "Coder not found");
        }else {
            confirm = JOptionPane.showConfirmDialog(null,"Are you sure want to delete the coder? \n"+ objCoder.toString());
            if(confirm == 0) objCoderModel.delete(objCoder);
        }

    }
    public static void getByName(){
        
        String nameFound = JOptionPane.showInputDialog("\n Enter the name to find: ");

        CoderModel objCoderModel = new CoderModel();

        String listaString = "COINCIDENCIAS \n";
        for(Coder iterador: objCoderModel.findByname(nameFound)){
            Coder objCoder = (Coder) iterador;
                    listaString += objCoder.toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, listaString);

    }


}
