package app.dao;

import app.entity.Appointment;
import app.exception.PatientNumberNotFoundException;

import java.util.List;

public interface IHospitalService {
    public Appointment getAppointmentById(int appointmentId);
    public List<Appointment> getAppointmentsForPatient(int patientId) throws PatientNumberNotFoundException;
    public List<Appointment> getAppointmentsForDoctors(int doctorId);
    public boolean scheduleAppointment(Appointment appointment);
    public boolean updateAppointment(Appointment appointment);
    public boolean cancelAppointment(int appointmentId);
}
