package entity;

public class Appointment {
    private int id_appointment;
    private int id_patient_appointment;
    private int id_medico_appointment;
    private String date_appointment;
    private String hour_appointment;
    private String reason;

    //CONSTRUCTOR

    public Appointment(int id_patient_appointment, int id_medico_appointment, String date_appointment, String hour_appointment, String reason) {
        this.id_patient_appointment = id_patient_appointment;
        this.id_medico_appointment = id_medico_appointment;
        this.date_appointment = date_appointment;
        this.hour_appointment = hour_appointment;
        this.reason = reason;
    }

    public Appointment() {
    }
    //GETTERS AND SETTERS

    public int getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(int id_appointment) {
        this.id_appointment = id_appointment;
    }

    public int getId_patient_appointment() {
        return id_patient_appointment;
    }

    public void setId_patient_appointment(int id_patient_appointment) {
        this.id_patient_appointment = id_patient_appointment;
    }

    public int getId_medico_appointment() {
        return id_medico_appointment;
    }

    public void setId_medico_appointment(int id_medico_appointment) {
        this.id_medico_appointment = id_medico_appointment;
    }

    public String getDate_appointment() {
        return date_appointment;
    }

    public void setDate_appointment(String date_appointment) {
        this.date_appointment = date_appointment;
    }

    public String getHour_appointment() {
        return hour_appointment;
    }

    public void setHour_appointment(String hour_appointment) {
        this.hour_appointment = hour_appointment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public String info(){
        return "Appointment{" +
                "id_appointment=" + id_appointment +
                ", id_patient=" + id_patient_appointment +
                ", id_medico=" + id_medico_appointment +
                ", date_appointment=" + date_appointment +
                ", hour_appointment=" + hour_appointment +
                ", reason='" + reason + '\'' +
                '}';
    };

    @Override
    public String toString() {
        return "Appointment{" +
                ", id_patient=" + id_patient_appointment +
                ", id_medico=" + id_medico_appointment +
                ", date_appointment=" + date_appointment +
                ", hour_appointment=" + hour_appointment +
                ", reason='" + reason + '\'' +
                '}';
    }
}
