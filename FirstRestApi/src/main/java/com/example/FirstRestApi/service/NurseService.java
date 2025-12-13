package com.example.FirstRestApi.service;

import com.example.FirstRestApi.model.Nurse;
import com.example.FirstRestApi.repository.NurseRepository;

import java.util.ArrayList;
import java.util.List;

public class NurseService {
    NurseRepository nurseRepository = new NurseRepository();

    public String addNurse(Nurse nurse) {
        if(nurse.getNurseId() < 0) {
            throw new IllegalArgumentException("Nurse ID invalid");
        }
        if(nurse.getName() == null) {
            throw new IllegalArgumentException("Name is Null");
        }
        String ans = nurseRepository.addNurse(nurse);
        return ans;
    }

    public List<Nurse> getAllNurses() {
        return new ArrayList<>();
    };

    public List<Nurse> getAllNursesWithQualification(){
        return new ArrayList<>();
    };
}
