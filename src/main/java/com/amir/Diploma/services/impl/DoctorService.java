package com.amir.Diploma.services.impl;

import com.amir.Diploma.models.Doctor;
import com.amir.Diploma.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(new Doctor(0L, "NO Name","No Description",null,0,0));
    }

}
