package app.dao;

import app.entity.Appointment;
import app.exception.PatientNumberNotFoundException;

import java.util.List;

public class HospitalServiceImpl implements IHospitalService {
    @Override
    public Appointment getAppointmentById(int appointmentId){

    }

    @Override
    public List<Appointment> getAppointmentsForPatient(int patientId) throws PatientNumberNotFoundException{

    }

    @Override
    public List<Appointment> getAppointmentsForDoctor(int doctorId){

    }

    @Override
    public boolean scheduleAppointment(Appointment appointment){

    }

    @Override
    public boolean updateAppointment(Appointment appointment){

    }

    @Override
    public boolean cancelAppointment(int appointmentId){

    }



}
