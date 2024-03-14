public class Empleado extends Persona{
    private int idEmpleado;
    private double salario;

    //constructor

    public Empleado(String nombre, int edad, int idEmpleado, double salario) {
        super(nombre, edad);
        this.idEmpleado = idEmpleado;
        this.salario = salario;
    }



    //setters and getters
    public int setIdEmpleado(int idEmpleado){
        return idEmpleado;
    }
    public double setSalario(double salario){
        return salario;
    }

    public void getIdEmpleado(){
        this.idEmpleado = idEmpleado;
    }
    public void salario(){
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", salario=" + salario +
                '}';
    }
}
