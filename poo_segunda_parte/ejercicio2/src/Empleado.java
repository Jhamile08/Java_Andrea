public class Empleado extends Persona{
    private int idEmpleado;
    private double salario;
    private String tipoEmpleado;

    //constructor
    Empleado(String nombre, int edad, int idEmpleado, double salario, String tipoEmpleado) {
        super(nombre, edad);
        this.idEmpleado = idEmpleado;
        this.salario = salario;
        this.tipoEmpleado = tipoEmpleado;
    }



    //setters and getters
    public int setIdEmpleado(int idEmpleado){
        return idEmpleado;
    }
    public double setSalario(double salario){
        return salario;
    }

    public int getIdEmpleado(){
        return idEmpleado;
    }
    public void salario(){
        this.salario = salario;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre=" + getNombre() +
                "idEmpleado=" + idEmpleado +
                ", salario=" + salario +
                ", tipoEmpleado='" + tipoEmpleado + '\'' +
                '}';
    }
}
