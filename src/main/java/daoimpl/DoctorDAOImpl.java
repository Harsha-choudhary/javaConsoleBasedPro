package daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DoctorDAO;
import model.Doctor;
import model.Patient;

public class DoctorDAOImpl implements DoctorDAO {
    private Connection connection;

    public DoctorDAOImpl(Connection connection) {
        this.connection = connection;
    }

	/*
	 * public void addDoctor(Doctor doctor) {
	 * 
	 * // Implement database interaction to add a doctor }
	 */
    
    public void addDoctor(Doctor doctor) {
        String query = "INSERT INTO doctors (id, name, specialization) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Ensure that the name is correctly set
            stmt.setInt(1, doctor.getId());
            stmt.setString(2, doctor.getName());
            stmt.setString(3, doctor.getSpecialization());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	/*
	 * public List<Doctor> getAllDoctors1() { // Implement database interaction to
	 * get all doctors return null; // Return list of doctors }
	 */
	
    
    
    
    
    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM doctors")) {
            while (rs.next()) {
                doctors.add(new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("specialization")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

@Override
public void deleteDoctorById(int id) {
    String query = "DELETE FROM doctors WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Doctor with ID " + id + " has been deleted successfully.");
        } else {
            System.out.println("No doctor found with ID " + id);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}

/*
 * @Override public void addDoctor(Doctor doctor) { // TODO Auto-generated
 * method stub
 * 
 * } }
 */
/*
 * @Override public void addDoctor(Doctor doctor) { // TODO Auto-generated
 * method stub
 * 
 * }
 */
/*
 * @Override public void addDoctor(Doctor doctor) { // TODO Auto-generated
 * method stub
 * 
 * } }
 */

/*
 * @Override public List<Doctor> getAllDoctors() { List<Doctor> doctors = new
 * ArrayList<>(); String query = "SELECT * FROM doctors"; //
 * 
 * try (PreparedStatement statement = connection.prepareStatement(query);
 * ResultSet resultSet = statement.executeQuery()) {
 * 
 * while (resultSet.next()) { int id = resultSet.getInt("id"); String name =
 * resultSet.getString("name"); String specialization =
 * resultSet.getString("specialization"); doctors.add(new Doctor(id, name,
 * specialization)); } } catch (SQLException e) { e.printStackTrace(); }
 * 
 * return doctors.isEmpty() ? null : doctors; // }
 * 
 * } }
 * 
 */



	