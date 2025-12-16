package com.example.FirstRestApi.controller;

import com.example.FirstRestApi.model.Doctor;
import com.example.FirstRestApi.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorService doctorService2;

    @PostMapping("/doctors")
    public String addDoctor(@RequestBody Doctor doctor) {
        System.out.println(doctorService);
        System.out.println(doctorService2);
        return doctorService.addDoctor(doctor);
    }

    @PostMapping(value ="/doctors/bulk")
    public String addDoctors(@RequestBody List<Doctor> doctors) {
        return doctorService.addDoctorsInBulk(doctors);
    }

    //You do NOT need to write @RequestParam("specialization"), Spring will automatically match it using the method parameter name.
    @GetMapping("/doctors")
    public List<Doctor> getDoctors(@RequestParam(required = false) Integer minExperience, @RequestParam(required = false) String specialization) {
        return doctorService.getAllDoctors(minExperience, specialization);
    }

    // User input during API calls : Request Body, Path Variable, Query Parameters

    @GetMapping("/doctors/{doctorId}")
    public Doctor getDoctorById(@PathVariable("doctorId") Integer doctorId) {
        return doctorService.getDoctorById(doctorId);
    }

    @PutMapping("/doctors/{doctorId}")
    public Doctor updateDoctorById(@PathVariable Integer doctorId, @RequestBody Doctor updatedDoctor) {
        return doctorService.updateDoctor(doctorId, updatedDoctor);
    }

    @DeleteMapping("/doctors/{doctorId}")
    public String deleteDoctorById(@PathVariable("doctorId") Integer doctorId) {
        if(!doctorService.containsDoctor(doctorId)) {
            return "Doctor not present";
        }
        doctorService.deleteDoctor(doctorId);
        return "Doctor deleted successfully!!";
    }
}
