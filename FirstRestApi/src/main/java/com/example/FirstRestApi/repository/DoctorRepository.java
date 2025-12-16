package com.example.FirstRestApi.repository;

import com.example.FirstRestApi.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class DoctorRepository {

    HashMap<Integer, Doctor> doctorDb = new HashMap<>();

    public String save(Doctor doctor) {
        doctorDb.put(doctor.getDoctorId(), doctor);
        return "Doctor saved successfully!!";
    }

    public Doctor findById(Integer id) {
        if(doctorDb.containsKey(id)) {
            return doctorDb.get(id);
        }
        return null;
    }

    public String update(Integer id, Doctor doctor) {
        if(findById(id) == null) {
            return "Doctor not present, updation failed!!";
        }
        doctorDb.put(id, doctor);
        return "Doctor updated successfully!!";
    }

    public List<Doctor> findAll() {
        return doctorDb.values().stream().toList();
    }

    public String delete(Integer doctorId) {
        if(findById(doctorId) == null) {
            return "No deletion, Doctor not found!!";
        }
        doctorDb.remove(doctorId);
        return "Doctor deleted successfully";
    }
}
