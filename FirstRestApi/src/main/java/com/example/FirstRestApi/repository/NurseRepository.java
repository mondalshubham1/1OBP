package com.example.FirstRestApi.repository;

import com.example.FirstRestApi.model.Nurse;

import java.util.HashMap;
import java.util.List;

public class NurseRepository {
    HashMap<Integer, Nurse> nurseDb = new HashMap<Integer, Nurse>();

    public String addNurse(Nurse nurse) {
        int key = nurse.getNurseId();
        nurseDb.put(key, nurse);
        return "Nurse added successfully";
    }

    public List<Nurse> getAllNurses() {
        return nurseDb.values().stream().toList();
    }

    public Nurse getNurse(int nurseId) {
        return nurseDb.get(nurseId);
    }
}
