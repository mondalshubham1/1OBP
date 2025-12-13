package com.example.FirstRestApi.model;

public class Nurse extends Person{
    private int nurseId;
    private String qualification;


    public Nurse(String name, String address, String phoneNumber, int age, int nurseId, String qualification) {
        super(name, address, phoneNumber, age);
        this.nurseId = nurseId;
        this.qualification = qualification;
    }


    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
