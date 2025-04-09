package app.entity;

import java.util.Date;

public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String contactNumber;
    private String address;

    public Patient(){

    }

    public Patient(int patientId, String firstName, String lastName, Date dateOfBirth, String gender, String contactNumber, String address){
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    //Getter methods
    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    //setter methods

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //Overriding toString() method
    @Override
    public String toString() {
        return "Patient { " +
                "Patient ID: " + patientId +
                ", First Name: '" + firstName + '\'' +
                ", Last Name: '" + lastName + '\'' +
                ", Date of Birth: " + dateOfBirth +
                ", Gender: '" + gender + '\'' +
                ", Contact Number: '" + contactNumber + '\'' +
                ", Address: ' " + address + '\'' +
                " }";
    }

    public void display_patient_details(){
        System.out.println("PatientId: " + patientId);
        System.out.println("FirstName: " + firstName);
        System.out.println("LastName: " + lastName);
        System.out.println("DateOfBirth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("ContactNumber: " + contactNumber);
        System.out.println("Address: " + address);
    }
}
