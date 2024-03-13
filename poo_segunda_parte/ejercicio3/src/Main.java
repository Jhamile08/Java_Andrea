//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Instancias
        Scanner objScan = new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();


        int option = 0;
        do {
            System.out.println("""
                    MENU
                    1. Administrar Estudiantes
                    2. Administrar Cursos
                    3. Salir
                    Ingrese una opcion: 
                    """);
            option = objScan.nextInt();

            switch (option){
                case 1:
                    int option3 = 0;
                    do {
                        System.out.println("""
                                MENU ESTUDIANTES
                                1. Agregar estudiantes a un curso
                                2. Listar todos los estudiantes
                                3. Eliminar estudiante
                                4. Salir
                                Ingresa una opcion:
                                """);
                        option3 = objScan.nextInt();
                        switch (option3){
                            case 1:
                                objGestion.listarTodosLosCursos();
                                System.out.println("Ingresa el codigo del curso donde ingresaras el nuevo estuduante");
                                String codigo = objScan.next();

                                Curso objCurso = objGestion.buscarCursoPorCodigo(codigo);

                                if(objCurso == null){
                                    System.out.println("El codigo ingresado no es valido");
                                }else{
                                    objCurso.agregarEstudiante(objScan);
                                }
                                break;
                            case 2:
                                objGestion.listarTodosLosCursos();
                                System.out.println("Ingresa el codigo del curso donde ingresaras el nuevo estuduante");
                                 codigo = objScan.next();

                                 objCurso = objGestion.buscarCursoPorCodigo(codigo);

                                if(objCurso == null){
                                    System.out.println("El codigo ingresado no es valido");
                                }else{
                                    objCurso.listarEstudiantes();
                                }
                                break;
                            case 3:// Eliminar estudiantes a un curso en
                                //1. listar los cursos
                                objGestion.listarTodosLosCursos();                                //2. preguntar el codigo del curso
                                //2. preguntar el codigo
                                System.out.println("Ingresa el codigo del curso donde deseas eliminar el estudiante");
                                codigo = objScan.next();
                                //3. buscar el curso que tenga ese codigo
                                Curso objcurso =  objGestion.buscarCursoPorCodigo(codigo);
                                if(objcurso == null){
                                    System.out.println("El codigo ingresado no coincide con ningun curso");
                                }else{
                                    //4. eliminar el estudiante de ese curso encontrado
                                    objcurso.eliminarEstudiante(objScan);
                                }

                            break;
                        }
                    }while(option3 != 4);
                case 2:
                    int option2 = 0;
                    do {
                        System.out.println("""
                                MENU CURSOS
                                1. Agregar Curso
                                2. Listar Cursos
                                3. Buscar curso por codigo
                                4. Salir
                                """);
                        option2 = objScan.nextInt();
                    switch (option2){
                        case 1:
                            objGestion.agregarCursos(objScan);
                            break;
                        case 2:
                            objGestion.listarTodosLosCursos();
                            break;
                        case 3:
                            System.out.println("Ingresa el codigo del curso a buscar");
                            String codigo = objScan.next();

                            Curso objCurso = objGestion.buscarCursoPorCodigo(codigo);
                            if (objGestion.buscarCursoPorCodigo(codigo) == null) {
                                System.out.println("No existe ningun curso con este codigo");

                            }else {
                                System.out.println(objCurso.toString());
                            }
                            break;
                    }

                    }while(option2 != 4);

            }
         //break;
        }while(option != 3);

    }
}