package com.example.FirstRestApi.controller;

import com.example.FirstRestApi.model.Doctor;
import com.example.FirstRestApi.repository.DoctorRepository;
import com.example.FirstRestApi.service.DoctorService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.print.Doc;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;

@RestController
public class DoctorController {
    private DoctorService doctorService;

    DoctorController(DoctorService doctorService) {
        System.out.println("DoctorController parametrized constructor is called");
        this.doctorService = doctorService;
    }

    @Autowired
    ApplicationContext context;


    @PostMapping("/doctors")
    public String addDoctor(@RequestBody Doctor doctor) {
        System.out.println(doctorService);

        String[] beanNames = context.getBeanNamesForType(DoctorRepository.class);

        System.out.println("Count = " + beanNames.length);
        System.out.println(Arrays.toString(beanNames));

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
        return doctorService.deleteDoctor(doctorId);
    }
}
