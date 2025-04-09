package app.entity;

import java.util.Date;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private Date appointmentDate;
    private String description;

    public Appointment(){

    }

    public Appointment(int appointmentId, int patientId, int doctorId, Date appointmentDate, String description){
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public Appointment(int patientId, int doctorId, Date appointmentDate, String description) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    //setter methods


    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Getter methods


    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Appointment { " +
                "Appointment ID: " + appointmentId +
                ", Patient ID: " + patientId +
                ", Doctor ID: " + doctorId +
                ", Appointment Date: " + appointmentDate +
                ", Description: '" + description + '\'' +
                " }";
    }

    public void display_appointment_details(){
        System.out.println("AppointmentId: " + appointmentId);
        System.out.println("PatientId: "+patientId);
        System.out.println("DoctorId: " + doctorId);
        System.out.println("AppointmentDate: " + appointmentDate);
        System.out.println("Description: " + description);
    }
}
