import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
    Scanner objScan = new Scanner(System.in);
    GestionEmpleado objEmpleado = new GestionEmpleado();

        String option = "";
        do {
          option =  JOptionPane.showInputDialog(null, "MENU\n"+
                    "1. agregar empleado\n" +
                    "2. eliminar empleado\n" +
                    "3. para listar empleado\n" +
                    "4. Salir\n" +
                    "Ingrese una opcion: ");

            switch (option) {
                case "1":
                    objEmpleado.añadirEmpleado();
                    break;
                case "2":
                    objEmpleado.listarTodosLosEmpleados();
                    objEmpleado.eliminarEmpleado();
                    break;
                case "3":
                    objEmpleado.listarTodosLosEmpleados();
                break;
            }

        }  while (!option.equalsIgnoreCase("4"));


    }
}