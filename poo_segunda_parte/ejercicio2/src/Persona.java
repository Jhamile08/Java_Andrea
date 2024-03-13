public class Persona {
    private String nombre;
    private int edad;

    //constructor
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
    // setters and getters
    public void setNombre(String nombre){ this.nombre = nombre;}
    public void setEdad(int edad){ this.edad = edad;}

    public String getNombre(){ return nombre;}
    public int getEdad(){ return edad;}

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
