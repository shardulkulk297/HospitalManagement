INSERT INTO patient (firstName, lastName, dateOfBirth, gender, contactNumber, address) 
VALUES 
('John', 'Doe', '1990-05-12', 'Male', '9876543210', '123 Main Street'),
('Jane', 'Smith', '1985-08-23', 'Female', '9123456789', '456 Oak Avenue'),
('Michael', 'Johnson', '1992-01-15', 'Male', '9988776655', '789 Pine Road'),
('Emily', 'Clark', '1998-07-19', 'Female', '9898989898', '321 Maple Lane'),
('David', 'Brown', '1980-03-05', 'Male', '9112233445', '555 Cedar Blvd');

INSERT INTO doctor (firstName, lastName, specialization, contactNumber) 
VALUES 
('Sarah', 'Miller', 'Cardiology', '9999999999'),
('Robert', 'Williams', 'Orthopedics', '8888888888'),
('Anna', 'Davis', 'Pediatrics', '7777777777'),
('James', 'Garcia', 'Dermatology', '6666666666'),
('Laura', 'Martinez', 'Dentistry', '5555555555');

INSERT INTO appointment (patientId, doctorId, appointmentDate, description) 
VALUES 
(1, 1, '2025-04-10', 'Regular checkup'),
(2, 3, '2025-04-12', 'Child vaccination'),
(3, 2, '2025-04-15', 'Knee pain consultation'),
(4, 5, '2025-04-18', 'Tooth filling'),
(5, 4, '2025-04-20', 'Skin rash treatment');
