package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dao.PatientDAO;
import model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    private Connection connection;

    public PatientDAOImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients (name, age, gender) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Ensure that the name is correctly set
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getGender());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePatientById(int id) {
        String query = "DELETE FROM patients WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Patient with ID " + id + " has been deleted successfully.");
            } else {
                System.out.println("No patient found with ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
  


    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM patients")) {
            while (rs.next()) {
                patients.add(new Patient(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("gender")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
}

