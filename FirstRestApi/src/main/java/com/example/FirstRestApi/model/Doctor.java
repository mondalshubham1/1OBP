package com.example.FirstRestApi.model;

public class Doctor extends Person{
    private int doctorId;
    private String specialization;
    private String degree;
    private int experience;


    public Doctor(String name, String address, String phoneNumber, int age, int doctorId, String specialization, String degree, int experience) {
        super(name, address, phoneNumber, age);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.degree = degree;
        this.experience = experience;
    }

    public int getDoctorId() {
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
