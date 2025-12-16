package com.example.FirstRestApi.service;

import com.example.FirstRestApi.model.Doctor;
import com.example.FirstRestApi.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Scope("prototype")
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public String addDoctorsInBulk(List<Doctor> doctorList) {
        int added = 0;

        for (Doctor doctor : doctorList) {
            Integer id = doctor.getDoctorId();
            if (!containsDoctor(id)) {
                doctorRepository.save(doctor);
                added++;
            }
            else {
                doctorRepository.update(id, doctor);
            }
        }

        return added + " doctors added (duplicates ignored)";
    }

    public boolean containsDoctor(Integer id) {
        if (doctorRepository.findById(id) == null)
            return false;
        else
            return true;
    }

    public Doctor updateDoctor(Integer doctorId, Doctor updatedDoctor) {
        if (!containsDoctor(doctorId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Doctor not found"
            );
        }

        if (updatedDoctor.getDoctorId() != null &&
                !doctorId.equals(updatedDoctor.getDoctorId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "ID mismatch"
            );
        }

        doctorRepository.update(doctorId, updatedDoctor);
        return updatedDoctor;
    }

    public List<Doctor> getAllDoctors(Integer minExperience, String specialization) {
        return doctorRepository.findAll().stream()
                .filter(d -> specialization == null ||
                        d.getSpecialization().equalsIgnoreCase(specialization))
                .filter(d -> minExperience == null ||
                        d.getExperience() >= minExperience)
                .toList();
    }

    public Doctor getDoctorById(Integer doctorId) {
        return doctorRepository.findById(doctorId);
    }

    public String deleteDoctor(Integer doctorId) {
        return doctorRepository.delete(doctorId);
    }
}
