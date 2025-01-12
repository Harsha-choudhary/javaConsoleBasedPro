package daoimpl;

import dao.AppointmentDAO;
import model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {
    private Connection connection;

    public AppointmentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void bookAppointment(Appointment appointment) {
        String query = "INSERT INTO appointments (patient_id, doctor_id, appointmen_date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, appointment.getPatientId());
            stmt.setInt(2, appointment.getDoctorId());
            stmt.setDate(3, Date.valueOf(appointment.getAppointmentDate())); // Ensure the date is in proper format
            stmt.executeUpdate();
            System.out.println("Appointment booked successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to book appointment.");
        }
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                appointments.add(new Appointment(
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getDate("appointmen_date").toString()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public void deleteAppointmentById(int id) {
        String query = "DELETE FROM appointments WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Appointment deleted successfully!");
            } else {
                System.out.println("Appointment not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to delete appointment.");
        }
    }
}

