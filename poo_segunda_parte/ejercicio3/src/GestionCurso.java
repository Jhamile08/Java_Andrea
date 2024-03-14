import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionCurso {
    private ArrayList<Curso> listaCursos;
    public GestionCurso(){
        this.listaCursos = new ArrayList<>();
    }
    public void agregarCursos(Scanner objScan){
        System.out.println("Ingresa el nombre del nuevo curso");
        String nombre = objScan.next();

        System.out.println("Ingresa el codigo del nuevo curso");
        String codigo = objScan.next();

        this.buscarCursoPorCodigo(codigo);
        if(this.buscarCursoPorCodigo(codigo) != null){
            System.out.println("Ya existe un curso con este codigo");
        }else{
            Curso objCurso = new Curso(codigo, nombre);
           if(this.listaCursos.add(objCurso)){
               System.out.println("Curso agregar correctamente");
           } else {
               System.out.println("No se pudo agregar el curso");
           }
        }

    }
    public void listarTodosLosCursos(){
        if(this.listaCursos.isEmpty()){
            System.out.println("No hay cursos registrados");
        }else{
            for (Curso iterador : this.listaCursos){
                System.out.println(iterador.toString());
        }


        }
    }
    public Curso buscarCursoPorCodigo(String codigoBuscar){
        for(Curso temporal:this.listaCursos){
            if(temporal.getCodigo().equalsIgnoreCase(codigoBuscar)){
                return temporal;
            }
        }
        return null;
    }

}
