package app.exception;

public class PatientNumberNotFoundException extends Exception {
    PatientNumberNotFoundException(String message){
        super(message);
    }
}
