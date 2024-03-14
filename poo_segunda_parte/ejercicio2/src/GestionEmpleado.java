import java.util.ArrayList;
import java.util.Scanner;

public class GestionEmpleado {
    int idEmpleado = 1;
    private ArrayList<Empleado> listaEmpleados;

    //constructor
    public GestionEmpleado(){
        this.listaEmpleados = new ArrayList<>();
    }

    //metodos
    public void añadirEmpleado(Scanner objScan){
        System.out.println("Ingresa el nombre del nuevo empleado: ");
        String nombre = objScan.nextLine();

        System.out.println("Ingresa la edad del nuevo empleado: ");
        int edad = objScan.nextInt();

        System.out.println("Ingresa el salario del nuevo empleado: ");
        double salario = objScan.nextDouble();

        Empleado objEmpleado = new Empleado(nombre,edad,idEmpleado,salario);
        idEmpleado++;

        System.out.println("Empleado, agregado correctamente");


    }
    public void eliminarEmpleado(){

    }
    public void mostrarEmpleados(){

    }
}
