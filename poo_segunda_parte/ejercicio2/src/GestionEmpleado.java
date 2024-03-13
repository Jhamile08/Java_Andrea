import java.util.ArrayList;
import java.util.Scanner;
public class GestionEmpleado {
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

    }
    public void eliminarEmpleado(){

    }
    public void mostrarEmpleados(){

    }
}
