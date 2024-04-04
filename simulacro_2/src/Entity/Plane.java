package Entity;

public class Plane {
    int id_plane;
    String model;
    int capacity;

    //CONSTRUCTORS
    public Plane(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    public Plane() {
    }

    //SETTERS AND GETTERS
    public int getId_plane() {
        return id_plane;
    }

    public void setId_plane(int id_plane) {
        this.id_plane = id_plane;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String info(){
        return "Plane{" +
                "id_plane=" + id_plane +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id_plane=" + id_plane +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
