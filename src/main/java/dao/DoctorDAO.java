package dao;

import java.util.List;

import model.Doctor;

public interface DoctorDAO {
    void addDoctor(Doctor doctor);
    List<Doctor> getAllDoctors()

;
    void deleteDoctorById(int id);

   String query = "SELECT * FROM doctors";
    // execute query and return results
}

