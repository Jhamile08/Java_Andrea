package Entity;

public class Flight {
    int id_flight;
    String destination;
    String departure_date;
    String departure_time;
    int id_plane;

    //CONSTRUCTOR
    public Flight(String destination, String departure_date, String departure_time, int id_plane) {
        this.destination = destination;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.id_plane = id_plane;
    }

    public Flight() {
    }

    //GETTERS AND SETTERS

    public int getId_flight() {
        return id_flight;
    }

    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public int getId_plane() {
        return id_plane;
    }

    public void setId_plane(int id_plane) {
        this.id_plane = id_plane;
    }
    public String info() {
        return "Flight{" +
                "id_flight=" + id_flight +
                ", destination='" + destination + '\'' +
                ", departure_date='" + departure_date + '\'' +
                ", departure_time='" + departure_time + '\'' +
                ", id_plane=" + id_plane +
                '}';
    }
    @Override
    public String toString() {
        return "Destination : '" + destination + '\'' +
                ", departure date : '" + departure_date + '\'' +
                ", departure time : " + departure_time + '\''+
                ", id_plane=" + id_plane
                ;
    }
}
