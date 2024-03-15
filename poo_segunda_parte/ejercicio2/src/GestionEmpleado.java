import javax.swing.*;
import java.util.ArrayList;


public class GestionEmpleado {
    int idEmpleado = 1;
    private ArrayList<Empleado> listaEmpleados;

    //constructor
    public GestionEmpleado() {
        this.listaEmpleados = new ArrayList<>();
    }

    //metodos
    public void añadirEmpleado() {

        String optionAdd = "";
        optionAdd = JOptionPane.showInputDialog(null, "Bienvenido a agregar empleado\n" +
                "1. Agregar empleado temporal\n" +
                "2. Agregar empleado permanente\n" +
                "3. Salir");
        String nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del nuevo empleado: ");

        String edad = JOptionPane.showInputDialog(null, "Ingresa la edad del nuevo empleado: ");

        String salario = JOptionPane.showInputDialog(null, "Ingresa el salario del nuevo empleado: ");

        switch (optionAdd) {
            case "1":

                Empleado objEmpleado = new Empleado(nombre, Integer.parseInt(edad), idEmpleado, Double.parseDouble(salario), "empleado temporal");
                idEmpleado++;

                if (this.listaEmpleados.add(objEmpleado)) {
                    JOptionPane.showMessageDialog(null,"Empleado temporal agregar correctamente");
                } else {
                    JOptionPane.showMessageDialog(null,"No se pudo agregar");
                }
                break;

            case "2":

                objEmpleado = new Empleado(nombre, Integer.parseInt(edad), idEmpleado, Double.parseDouble(salario), "empleado permanente");
                idEmpleado++;

                if (this.listaEmpleados.add(objEmpleado)) {
                    JOptionPane.showMessageDialog(null,"Empleado permanente agregar correctamente");
                } else {
                    JOptionPane.showMessageDialog(null,"No se pudo agregar");
                }
                break;

        }


    }

    public void listarTodosLosEmpleados() {
        if (this.listaEmpleados.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "No hay empleados registrados");
        } else {
            for (Empleado iterador : this.listaEmpleados) {
                JOptionPane.showMessageDialog(null, iterador.toString());
            }


        }
    }

    public void eliminarEmpleado() {

        String idEliminar = JOptionPane.showInputDialog("Eliminar id");

        if (this.listaEmpleados.removeIf(producto -> producto.getIdEmpleado() == Integer.parseInt(idEliminar))) {
            JOptionPane.showMessageDialog(null, "Eliminado ");
        }else {
            JOptionPane.showMessageDialog(null, "id no encontrado");
        }


    }
}


