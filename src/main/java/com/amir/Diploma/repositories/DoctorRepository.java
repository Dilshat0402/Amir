package com.amir.Diploma.repositories;

import com.amir.Diploma.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findAll();
}
