package dao;

import model.Appointment;
import java.util.List;

public interface AppointmentDAO {
    void bookAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    void deleteAppointmentById(int id);
}
