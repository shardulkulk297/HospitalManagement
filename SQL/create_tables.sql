-- Active: 1742545260664@@127.0.0.1@3306@hospitalmanagement
Create Database HospitalManagement;
USE HospitalManagement;

Create table Patient(
    patientId INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    dateOfBirth DATE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    contactNumber VARCHAR(15) NOT NULL,
    address VARCHAR(255) NOT NULL
);

Create Table Doctor(
    doctorId INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    specialization VARCHAR(50) NOT NULL,
    contactNumber VARCHAR(15) NOT NULL
);

Create Table Appointment(
    appointmentId INT PRIMARY KEY AUTO_INCREMENT,
    patientId INT NOT NULL,
    doctorId INT NOT NULL,
    appointmentDate DATE NOT NULL,
    description VARCHAR(100) NOT NULL,
    FOREIGN KEY (patientId) REFERENCES Patient(patientId),
    FOREIGN KEY (doctorId) REFERENCES Doctor(doctorId)
);