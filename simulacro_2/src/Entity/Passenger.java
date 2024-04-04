package Entity;

public class Passenger {
    int id_passenger;
    String name;
    String surname;
    String identity;

    //CONSTRUCTOR
    public Passenger(String name, String surname, String identity) {
        this.name = name;
        this.surname = surname;
        this.identity = identity;
    }

    public Passenger() {
    }

    //SETTERS AND GETTERS
    public int getId_passenger() {
        return id_passenger;
    }

    public void setId_passenger(int id_passenger) {
        this.id_passenger = id_passenger;
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id_passenger=" + id_passenger +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
