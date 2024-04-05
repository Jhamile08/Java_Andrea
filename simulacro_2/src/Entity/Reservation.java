package Entity;

public class Reservation {
    int id_reservation;
    String reservation_time;
    String seat;
    int id_passenger;
    int id_flight;

    //CONSTRUCTOR
    public Reservation(String reservation_time, String seat, int id_passenger, int id_flight) {
        this.reservation_time = reservation_time;
        this.seat = seat;
        this.id_passenger = id_passenger;
        this.id_flight = id_flight;
    }

    public Reservation() {
    }

    //SETTERS AND GETTERS
    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public String getReservation_time() {
        return reservation_time;
    }

    public void setReservation_time(String reservation_time) {
        this.reservation_time = reservation_time;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getId_passenger() {
        return id_passenger;
    }

    public void setId_passenger(int id_passenger) {
        this.id_passenger = id_passenger;
    }

    public int getId_flight() {
        return id_flight;
    }

    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }
    public String info() {
        return "Reservation{" +
                "id_reservation=" + id_reservation +
                ", reservation_time='" + reservation_time + '\'' +
                ", seat='" + seat + '\'' +
                ", id_passenger=" + id_passenger +
                ", id_flight=" + id_flight +
                '}';
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "id_reservation=" + id_reservation +
                ", reservation_time='" + reservation_time + '\'' +
                ", seat='" + seat + '\'';
    }
}
