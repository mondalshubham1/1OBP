package com.example.FirstRestApi.model;

public class Patient extends Person{
    private int patientId;
    private String disease;

    public Patient(String name, String address, String phoneNumber, int age, int patientId, String disease) {
        //super(name, address, phoneNumber, age);
        this.patientId = patientId;
        this.disease = disease;
    }


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
