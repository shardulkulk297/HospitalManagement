package app.dao;

import app.entity.Appointment;
import app.exception.PatientNumberNotFoundException;
import app.util.DBConnection;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalServiceImpl implements IHospitalService {
    private Connection con;
    private Appointment apo = null;

    HospitalServiceImpl(){
        try{
            con = DBConnection.getConnection();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }


    @Override
    public Appointment getAppointmentById(int appointmentId){



        if(appointmentId == 0 || appointmentId < 0)
        {
            System.out.println("Appointment ID cannot be 0 or less than 0");
        }

        try{

            String sql = "Select * from appointment WHERE appointmentId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, appointmentId);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                apo = new Appointment();
                apo.setAppointmentId(appointmentId);
                apo.setAppointmentDate(rs.getDate("appointmentDate"));
                apo.setPatientId(rs.getInt("patientId"));
                apo.setDescription(rs.getString("description"));
                apo.setDoctorId(rs.getInt("doctorId"));
            }


        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        finally {
            try{
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }

        }

        return apo;

    }

    @Override
    public List<Appointment> getAppointmentsForPatient(int patientId) throws PatientNumberNotFoundException{


        List<Appointment> appointments = new ArrayList<>();

        if(patientId == 0 || patientId < 0){
            System.out.println("Patient ID can't be 0");
            throw new PatientNumberNotFoundException("Patient ID can't be 0");

        }

        try{
            String sql = "Select * from appointment WHERE patientId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, patientId);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                apo = new Appointment();

                apo.setAppointmentId(rs.getInt("appointmentId"));
                apo.setPatientId(patientId);
                apo.setDoctorId(rs.getInt("doctorId"));
                apo.setAppointmentDate(rs.getDate("appointmentDate"));
                apo.setDescription(rs.getString("description"));

                appointments.add(apo);
            }

        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }

        finally {
            try{
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }

        }

        return appointments;

    }

    @Override
    public List<Appointment> getAppointmentsForDoctors(int doctorId){
        if(doctorId == 0 || doctorId < 0)
        {
            System.out.println("DOCTOR ID MUST BE A NUMBER WHICH IS NOT 0 AND NEGATIVE");
        }


        List<Appointment> appointments = new ArrayList<>();


        try{

            String sql = "Select * from appointment WHERE doctorId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, doctorId);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                apo = new Appointment();
                apo.setAppointmentId(rs.getInt("appointmentId"));
                apo.setDoctorId(doctorId);
                apo.setPatientId(rs.getInt("patientId"));
                apo.setDescription(rs.getString("description"));
                apo.setAppointmentDate(rs.getDate("appointmentDate"));

                appointments.add(apo);
            }

        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }

        finally {
            try{
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }

        }

        return appointments;

    }

    @Override
    public boolean scheduleAppointment(Appointment appointment){

        if(appointment == null){
            System.out.println("NO APPOINTMENTS!");
        }

        boolean scheduled = false;

        try{

            String sql = "Insert into appointment (patientId, doctorId, appointmentDate, description) VALUES(?, ?, ? , ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, appointment.getPatientId());
            stmt.setInt(2, appointment.getDoctorId());
            stmt.setDate(3, new Date(appointment.getAppointmentDate().getTime()));
            stmt.setString(4, appointment.getDescription());

            int rowsAdded = stmt.executeUpdate();

            if(rowsAdded > 0){
                scheduled = true;
                System.out.println("Appointment Scheduled Successfully");
            }
            else{
                System.out.println("SOMETHING WENT WRONG WHILE SCHEDULING");
            }


        }

         catch(SQLException e)
        {
            e.printStackTrace();
        }

        finally {
            try{
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }

        }
        return scheduled;

    }

    @Override
    public boolean updateAppointment(Appointment appointment){

        if(appointment == null){
            System.out.println("NO APPOINTMENTS!");
        }
        boolean update = false;

        try{

            String sql = "Update appointment SET patientId = ?, doctorId = ?, appointmentDate = ?, description = ? WHERE appointmentId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, appointment.getPatientId());
            stmt.setInt(2, appointment.getDoctorId());
            stmt.setDate(3, new Date(appointment.getAppointmentDate().getTime()));
            stmt.setString(4, appointment.getDescription());
            stmt.setInt(5, appointment.getAppointmentId());

            int rowsUpdated = stmt.executeUpdate();

            if(rowsUpdated > 0){
                update = true;
                System.out.println("UPDATED Successfully");
            }

            else{
                System.out.println("Something WENT WRONG");
            }


        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }

        finally {
            try{
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }

        }

        return update;


    }

    @Override
    public boolean cancelAppointment(int appointmentId){

        if(appointmentId ==0 || appointmentId < 0){
            System.out.println("APPOINTMENT ID CANNOT BE 0 OR NEGATIVE");
        }

        boolean cancel = false;

        try{
            String sql = "Delete * from appointment WHERE appointmentId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, appointmentId);

            int rowsDeleted = stmt.executeUpdate();

            if(rowsDeleted > 0)
            {
                cancel = true;
                System.out.println("DELETED SUCCESSFULLY");
            }
            else{
                System.out.println("SOMETHING WENT WRONG WHILW DELETEING");
            }

        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }

        finally {
            try{
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }

        }
        return cancel;

    }



}
