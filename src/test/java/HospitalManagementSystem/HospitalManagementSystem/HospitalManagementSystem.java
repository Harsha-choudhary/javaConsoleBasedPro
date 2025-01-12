/*
 * package HospitalManagementSystem.HospitalManagementSystem;
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.SQLException; import java.util.List; import java.util.Scanner;
 * import model.Appointment; import model.Doctor; import model.Patient; import
 * daoimpl.DoctorDAOImpl;
 * 
 * import daoimpl.AppointmentDAOImpl; import daoimpl.PatientDAOImpl;
 * 
 * public class HospitalManagementSystem {
 * 
 * public static void main(String[] args) { try (Connection connection =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root",
 * "Harsha@1810")) {
 * 
 * DoctorDAOImpl doctorDAO = new DoctorDAOImpl(connection); PatientDAOImpl
 * patientDAO = new PatientDAOImpl(connection); AppointmentDAOImpl
 * appointmentDAO = new AppointmentDAOImpl(connection);
 * 
 * Scanner scanner = new Scanner(System.in); while (true) {
 * System.out.println("1. Add Doctor"); System.out.println("2. View Doctors");
 * System.out.println("3. Add Patient"); System.out.println("4. View Patients");
 * System.out.println("5. delete doctor by id");
 * System.out.println("6. Delete Patient by ID");
 * System.out.println("7. Book Appointment");
 * System.out.println("8. View Appointments");
 * 
 * System.out.println("9. delete appointment"); System.out.println("10 . exit");
 * 
 * System.out.print("Choose an option: "); int choice = scanner.nextInt();
 * scanner.nextLine();
 * 
 * switch (choice) { case 1: System.out.print("Enter doctor name: "); String
 * docName = scanner.nextLine(); System.out.print("Enter specialization: ");
 * String specialization = scanner.nextLine(); // doctorDAO.addDoctor(new
 * Doctor(0, docName, specialization)); // break; // Create the Patient object
 * Doctor newDoctor = new Doctor(0, docName, specialization);
 * doctorDAO.addDoctor(newDoctor); // Add patient to the database break;
 * 
 * 
 * 
 * 
 * case 2: List<Doctor> doctors = doctorDAO.getAllDoctors(); if (doctors == null
 * || doctors.isEmpty()) { System.out.println("No doctors found."); } else {
 * doctors.forEach(System.out::println); } break;
 * 
 * 
 * case 3: System.out.print("Enter patient name: "); String patName =
 * scanner.nextLine().trim(); // Trim spaces around name if (patName.isEmpty())
 * { System.out.println("Patient name cannot be empty."); break; // Exit this
 * case and don't insert the patient }
 * 
 * // Handle invalid input for age int age = -1; boolean validAge = false; while
 * (!validAge) { System.out.print("Enter age: "); if (scanner.hasNextInt()) {
 * age = scanner.nextInt(); scanner.nextLine(); validAge = true; } else {
 * System.out.println("Invalid input. Please enter a valid age.");
 * scanner.nextLine(); } }
 * 
 * System.out.print("Enter gender: "); String gender = scanner.nextLine();
 * 
 * // Create the Patient object Patient newPatient = new Patient(0, patName,
 * age, gender); patientDAO.addPatient(newPatient); // Add patient to the
 * database break;
 * 
 * 
 * 
 * 
 * case 4: List<Patient> patients = patientDAO.getAllPatients();
 * patients.forEach(System.out::println); break;
 * 
 * 
 * 
 * case 5: System.out.print("Enter the ID of the doctor to delete: "); int
 * doctorId = scanner.nextInt(); doctorDAO.deleteDoctorById(doctorId); break;
 * 
 * case 6: System.out.print("Enter the ID of the patient to delete: "); int
 * patientId = scanner.nextInt(); patientDAO.deletePatientById(patientId);
 * break; case 7: // Book Appointment System.out.print("Enter Patient ID: ");
 * int patientIdForAppointment = scanner.nextInt();
 * System.out.print("Enter Doctor ID: "); int doctorIdForAppointment =
 * scanner.nextInt(); scanner.nextLine(); // Consume newline
 * System.out.print("Enter Appointment Date (YYYY-MM-DD): "); String
 * appointmentDate = scanner.nextLine(); Appointment newAppointment = new
 * Appointment(0, patientIdForAppointment, doctorIdForAppointment,
 * appointmentDate); appointmentDAO.bookAppointment(newAppointment);
 * System.out.println("Appointment booked successfully."); break;
 * 
 * case 8: // View Appointments List<Appointment> appointments =
 * appointmentDAO.getAllAppointments(); if (appointments.isEmpty()) {
 * System.out.println("No appointments found."); } else {
 * appointments.forEach(System.out::println); } break;
 * 
 * case 9: // Delete Appointment by ID
 * System.out.print("Enter Appointment ID to delete: "); int
 * appointmentIdToDelete = scanner.nextInt();
 * appointmentDAO.deleteAppointmentById(appointmentIdToDelete);
 * System.out.println("Appointment deleted successfully."); break;
 * 
 * 
 * case 10: System.out.println("Exiting..."); return;
 * 
 * default: System.out.println("Invalid choice!"); } } } catch (SQLException e)
 * { e.printStackTrace(); } } }
 */



package HospitalManagementSystem.HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Doctor;
import model.Patient;
import model.Appointment;
import daoimpl.DoctorDAOImpl;
import daoimpl.PatientDAOImpl;
import daoimpl.AppointmentDAOImpl;

public class HospitalManagementSystem {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Harsha@1810")) {

            // DAO Objects
            DoctorDAOImpl doctorDAO = new DoctorDAOImpl(connection);
            PatientDAOImpl patientDAO = new PatientDAOImpl(connection);
            AppointmentDAOImpl appointmentDAO = new AppointmentDAOImpl(connection);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n=== Hospital Management System ===");
                System.out.println("1. Manage Doctors");
                System.out.println("2. Manage Patients");
                System.out.println("3. Manage Appointments");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int mainChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (mainChoice) {
                    case 1: // Manage Doctors
                        manageDoctors(scanner, doctorDAO);
                        break;

                    case 2: // Manage Patients
                        managePatients(scanner, patientDAO);
                        break;

                    case 3: // Manage Appointments
                        manageAppointments(scanner, appointmentDAO);
                        break;

                    case 4: // Exit
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Manage Doctors Submenu
    private static void manageDoctors(Scanner scanner, DoctorDAOImpl doctorDAO) {
        while (true) {
            System.out.println("\n--- Manage Doctors ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Delete Doctor by ID");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Doctor
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter specialization: ");
                    String specialization = scanner.nextLine();
                    Doctor newDoctor = new Doctor(0, doctorName, specialization);
                    doctorDAO.addDoctor(newDoctor);
                    System.out.println("Doctor added successfully.");
                    break;

                case 2: // View Doctors
                    List<Doctor> doctors = doctorDAO.getAllDoctors();
                    if (doctors.isEmpty()) {
                        System.out.println("No doctors found.");
                    } else {
                        doctors.forEach(System.out::println);
                    }
                    break;

                case 3: // Delete Doctor
                    System.out.print("Enter Doctor ID to delete: ");
                    int doctorIdToDelete = scanner.nextInt();
                    doctorDAO.deleteDoctorById(doctorIdToDelete);
                    System.out.println("Doctor deleted successfully.");
                    break;

                case 4: // Back to Main Menu
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Manage Patients Submenu
    private static void managePatients(Scanner scanner, PatientDAOImpl patientDAO) {
        while (true) {
            System.out.println("\n--- Manage Patients ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Delete Patient by ID");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Patient
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    Patient newPatient = new Patient(0, patientName, age, gender);
                    patientDAO.addPatient(newPatient);
                    System.out.println("Patient added successfully.");
                    break;

                case 2: // View Patients
                    List<Patient> patients = patientDAO.getAllPatients();
                    if (patients.isEmpty()) {
                        System.out.println("No patients found.");
                    } else {
                        patients.forEach(System.out::println);
                    }
                    break;

                case 3: // Delete Patient
                    System.out.print("Enter Patient ID to delete: ");
                    int patientIdToDelete = scanner.nextInt();
                    patientDAO.deletePatientById(patientIdToDelete);
                    System.out.println("Patient deleted successfully.");
                    break;

                case 4: // Back to Main Menu
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Manage Appointments Submenu
    private static void manageAppointments(Scanner scanner, AppointmentDAOImpl appointmentDAO) {
        while (true) {
            System.out.println("\n--- Manage Appointments ---");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Delete Appointment by ID");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Book Appointment
                    System.out.print("Enter Patient ID: ");
                    int patientIdForAppointment = scanner.nextInt();
                    System.out.print("Enter Doctor ID: ");
                    int doctorIdForAppointment = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
                    String appointmentDate = scanner.nextLine();
                    Appointment newAppointment = new Appointment(0, patientIdForAppointment, doctorIdForAppointment, appointmentDate);
                    appointmentDAO.bookAppointment(newAppointment);
                    System.out.println("Appointment booked successfully.");
                    break;

                case 2: // View Appointments
                    List<Appointment> appointments = appointmentDAO.getAllAppointments();
                    if (appointments.isEmpty()) {
                        System.out.println("No appointments found.");
                    } else {
                        appointments.forEach(System.out::println);
                    }
                    break;

                case 3: // Delete Appointment
                    System.out.print("Enter Appointment ID to delete: ");
                    int appointmentIdToDelete = scanner.nextInt();
                    appointmentDAO.deleteAppointmentById(appointmentIdToDelete);
                    System.out.println("Appointment deleted successfully.");
                    break;

                case 4: // Back to Main Menu
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
