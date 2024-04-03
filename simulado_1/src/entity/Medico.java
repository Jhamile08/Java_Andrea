package entity;

public class Medico {
    private int id_medico;
    private String name;
    private String surname;
    private int id_specialty_foreing;

    //CONSTRUCTOR

    public Medico( String name, String surname, int id_specialty) {
        this.name = name;
        this.surname = surname;
        this.id_specialty_foreing = id_specialty;
    }

    public Medico() {
    }
    //Getters and setters


    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId_specialty_foreing() {
        return id_specialty_foreing;
    }

    public void setId_specialty_foreing(int id_specialty) {
        this.id_specialty_foreing = id_specialty;
    }


    @Override
    public String toString() {
        return "Medico{" +
                "id_medico=" + id_medico +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id_specialty_foreing=" + id_specialty_foreing +
                '}';
    }


}
