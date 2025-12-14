package com.example.FirstRestApi.model;

import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Doctor extends Person{
    private Integer doctorId;
    private String specialization;
    private String degree;
    private Integer experience;


    public Doctor() {
        super();
    }
    public Doctor(String name, String address, String phoneNumber, Integer age, Integer doctorId, String specialization, String degree, Integer experience) {
        super(name, address, phoneNumber, age);
        System.out.println("Parametrized constructor called");
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.degree = degree;
        this.experience = experience;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", specialization='" + specialization + '\'' +
                ", degree='" + degree + '\'' +
                ", experience=" + experience +
                '}' + super.toString();
    }
}
