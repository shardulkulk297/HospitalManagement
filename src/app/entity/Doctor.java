package app.entity;

public class Doctor {
    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String contactNumber;

    public Doctor(){

    }

    public Doctor(int doctorId, String firstName, String lastName,
                  String specialization, String contactNumber)
    {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
    }

    //setter methods


    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    //Getter methods
    public int getDoctorId() {
        return doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "Doctor { " +
                "Doctor ID: " + doctorId +
                ", First Name: '" + firstName + '\'' +
                ", Last Name: '" + lastName + '\'' +
                ", Specialization: '" + specialization + '\'' +
                ", Contact Number: '" + contactNumber + '\'' +
                " }";
    }

    public void display_doctor_details(){
        System.out.println("DoctorID: " + doctorId);
        System.out.println("FirstName: " + firstName);
        System.out.println("LastName: " + lastName);
        System.out.println("Specialization: " + specialization);
        System.out.println("ContactNumber: "  +contactNumber);
    }
}
