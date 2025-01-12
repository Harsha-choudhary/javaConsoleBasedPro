package dao;


import java.util.List;

import model.Patient;
import java.util.List;

public interface PatientDAO {
    void addPatient(Patient patient);
    List<Patient> getAllPatients();
    void deletePatientById(int id);

}
 