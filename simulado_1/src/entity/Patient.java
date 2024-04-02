package entity;

public class Patient {
    private int id_patient;
    private String name;
    private String surname;
    private String birth_date;
    private String identity;

   // CONTRUCTOR
    public Patient(int id_patient, String name, String surname, String birth_date, String identity) {
        this.id_patient = id_patient;
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
        this.identity = identity;
    }

    public Patient() {
    }

   // GETTERS AND SETTERS

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
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

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Patient : " +
                "id_patient : " + id_patient +
                ", name : '" + name + '\'' +
                ", surname : '" + surname + '\'' +
                ", birth_date : " + birth_date +
                ", identity='" + identity + '\'' +
                '}';
    }
}
