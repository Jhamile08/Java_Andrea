import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> listaEstudiantes;
    //un metodo estatico es el que se puede usar sin tener que insatanciar una clase basicamente termina siendo una
    //variable global
    private static int index = 1;

    // Constructor sin la lista de parametro ya que apenas la vamos a crear
    public Curso(String codigo, String nombre) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.listaEstudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Scanner objScan){
        objScan.nextLine();
        System.out.println("Ingrese el nombre del estudiante");
        String nombre = objScan.nextLine();

        System.out.println("Ingrese el email del estudiante");
        String email = objScan.nextLine();

        Estudiante objEstudiante = new Estudiante(index, nombre, email);
        index++;

        this.listaEstudiantes.add(objEstudiante);
        System.out.println("Estudiante agregado correctamente ");
    }
    public void listarEstudiantes(){
        if(this.listaEstudiantes.isEmpty()){
            System.out.println("No hay estudiantes en el curso".concat(this.nombre));
        }else {
            System.out.println("lista de estudiantes del curso ".concat(this.nombre));
            for ( Estudiante iterador : this.listaEstudiantes){
                System.out.println(iterador.toString());
            }

        }
    }
    public void eliminarEstudiante(Scanner objScan){
        this.listarEstudiantes();
        System.out.println("Ingrese el id del estudiante a eliminar");
        int idEliminar = objScan.nextInt();
        // Eliminamos el estudiante si su id coincide con el id que se desea eliminar
        boolean eliminado = this.listaEstudiantes.removeIf(estudiante -> estudiante.getId() == idEliminar);
        System.out.println(!eliminado
        ? "no se pudo eliminar el estudiante"
                        :"se elimino correctamente");
    }

    // getters and setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    // toString()

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }
}
