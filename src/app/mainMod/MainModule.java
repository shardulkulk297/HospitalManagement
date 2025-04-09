package app.mainMod;

import app.dao.HospitalServiceImpl;
import app.entity.Appointment;
import app.exception.PatientNumberNotFoundException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainModule {

    private static Date ConvertDate(LocalDate date){

        Date utilDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return utilDate;

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        while(true){
            System.out.println("--");
            System.out.println("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("--");
            System.out.println("Select Option");
            System.out.println("1. Get specific Appointments");
            System.out.println("2. Get Appointments for Patients");
            System.out.println("3. Get Appointments For Doctors");
            System.out.println("4. Schedule Appointment");
            System.out.println("5. Update Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("0. EXIT");
            System.out.println("Enter Your Option");
            int option = sc.nextInt();

            switch(option){
                case 1->{

                    System.out.println("Enter Appointment ID");
                    int apoId = sc.nextInt();

                    if(apoId == 0 || apoId < 0){
                        System.out.println("The id can't be 0 or negative");
                        break;

                    }

                    HospitalServiceImpl impl = new HospitalServiceImpl();
                    Appointment apo = impl.getAppointmentById(apoId);

                    System.out.println("Your Appointment: ");

                    if(apo == null){
                        System.out.println("NO APPOINTMENTS");
                    }
                    else{
                        System.out.println(apo);
                    }

                }

                case 2->{
                    System.out.println("Enter patient Id");
                    int patientId = sc.nextInt();

                    if(patientId == 0 || patientId < 0){
                        System.out.println("The id can't be 0 or negative");
                        break;
                    }



                    HospitalServiceImpl impl = new HospitalServiceImpl();
                    List<Appointment> appointments = new ArrayList<>();
                    try{
                        appointments = impl.getAppointmentsForPatient(patientId);

                    } catch (PatientNumberNotFoundException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Your Appointments");

                    if(appointments.isEmpty())
                    {
                        System.out.println("NO APPOINMENTS SCHEDULED");
                    }
                    else{
                        for(Appointment a: appointments){
                            System.out.println(a);
                        }

                    }

                }

                case 3->{
                    System.out.println("Enter DoctorId");
                    int doctorId = sc.nextInt();

                    if(doctorId == 0 || doctorId < 0){
                        System.out.println("The id can't be 0 or negative");
                        break;
                    }

                    HospitalServiceImpl impl = new HospitalServiceImpl();
                    List<Appointment> appointments = impl.getAppointmentsForDoctors(doctorId);
                    System.out.println("Doctor's Appointments:");

                    if(appointments.isEmpty()){
                        System.out.println("NO APPOINTMENTS");
                    }
                    else{

                        for(Appointment a: appointments){
                            System.out.println(a);
                        }


                    }


                }

                case 4->{
                    System.out.println("Schedule Appointment");

                    System.out.print("Enter Patient ID: ");
                    int patientId = sc.nextInt();

                    System.out.print("Enter Doctor ID: ");
                    int doctorId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Appointment Date (yyyy-MM-dd): ");
                    String dateInput = sc.nextLine();

                    LocalDate apDate = LocalDate.parse(dateInput);
                    Date utilDate = ConvertDate(apDate);

                    System.out.print("Enter Description: ");
                    String description = sc.nextLine();

                    Appointment appointment = new Appointment(patientId, doctorId, utilDate, description);



                    HospitalServiceImpl impl = new HospitalServiceImpl();

                    boolean scheduled =  impl.scheduleAppointment(appointment);

                    if(scheduled){
                        System.out.println("Appointment Scheduled");
                    }
                    else{
                        System.out.println("SOMETHING WENT WRONG TRY AGAIN");
                    }


                }

                case 5->{
                    System.out.println("Enter Appointment ID of the appointment you want to update");
                    int apoId = sc.nextInt();

                    HospitalServiceImpl impl = new HospitalServiceImpl();
                    LocalDate apDate = LocalDate.of(2025, 05, 10); //updating Date
                    Appointment appointment = new Appointment(apoId, 1, 3, ConvertDate(apDate), "Regular Checkup");

                    boolean updateStatus = impl.updateAppointment(appointment);
                    if(updateStatus){
                        System.out.println("Updated Successfully");
                    }
                    else{
                        System.out.println("SOMETHING WENT WRONG WHILE Updating");
                    }

                }

                case 6->{
                    System.out.println("Enter appointment ID to cancel: ");
                    int apoId = sc.nextInt();
                    HospitalServiceImpl impl = new HospitalServiceImpl();

                    boolean deleteStatus = impl.cancelAppointment(apoId);

                    if(deleteStatus){
                        System.out.println("CANCELED SUCCESSFULLY");
                    }
                    else{
                        System.out.println("SOMETHING WENT WRONG WHILE DELETING");
                    }

                }
                case 0->{
                    System.out.println("--");
                    System.out.println("Thanks for Visiting!! GoodByeeee😊");
                    System.out.println("--");
                    sc.close();
                    System.exit(0);
                }

                default -> {
                    System.out.println("WRONG OPTION");
                }
            }


        }




    }

}
