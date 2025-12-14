package com.example.FirstRestApi.controller;

import com.example.FirstRestApi.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@RestController
public class DoctorController {

    HashMap<Integer, Doctor> doctorDb = new HashMap<>();

    @PostMapping("/doctors")
    public String addDoctor(@RequestBody Doctor doctor) {

        Integer doctorId = doctor.getDoctorId();
        doctorDb.put(doctorId, doctor);

        return "Doctor added successfully" +  " " + doctor;
    }

    @PostMapping(value ="/doctors/bulk")
    public String addDoctors(@RequestBody List<Doctor> doctors) {
        int added = 0;

        for (Doctor doctor : doctors) {
            Integer id = doctor.getDoctorId();
            if (!doctorDb.containsKey(id)) {
                doctorDb.put(id, doctor);
                added++;
            }
        }

        return added + " doctors added (duplicates ignored)";
    }

    //You do NOT need to write @RequestParam("specialization"), Spring will automatically match it using the method parameter name.
    @GetMapping("/doctors")
    public List<Doctor> getDoctors(@RequestParam(required = false) Integer minExperience, @RequestParam(required = false) String specialization) {
        return doctorDb.values().stream()
                .filter(d -> specialization == null ||
                        d.getSpecialization().equalsIgnoreCase(specialization))
                .filter(d -> minExperience == null ||
                        d.getExperience() >= minExperience)
                .toList();
    }

    // User input during API calls : Request Body, Path Variable, Query Parameters

    @GetMapping("/doctors/{doctorId}")
    public Doctor getDoctorById(@PathVariable("doctorId") Integer doctorId) {
        if(doctorDb.containsKey(doctorId)) {
            return doctorDb.get(doctorId);
        }
        return doctorDb.get(doctorId);
    }

    @PutMapping("/doctors/{doctorId}")
    public Doctor updateDoctorById(@PathVariable Integer doctorId, @RequestBody Doctor updatedDoctor) {

        if (!doctorDb.containsKey(doctorId)) {
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

        doctorDb.put(doctorId, updatedDoctor);
        return updatedDoctor;
    }
}
