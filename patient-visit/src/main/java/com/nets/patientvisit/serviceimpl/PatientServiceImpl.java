/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.serviceimpl;

import com.nets.patientvisit.entity.Patient;
import com.nets.patientvisit.exception.ApplicationException;
import com.nets.patientvisit.repository.PatientRepository;
import com.nets.patientvisit.service.HolidayService;
import com.nets.patientvisit.service.PatientService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepo;

    @Override
    public List<Patient> findAll() {
        return patientRepo.findAll();
    }

    @Override
    @Transactional
    public Patient save(Patient req) {

        // Check for duplication ID
        patientRepo.findById(req.getId()).ifPresent(patient -> {
            throw new ApplicationException("Patient ID already exist: ".concat(patient.getId()), HttpStatus.CONFLICT);
        });

        return patientRepo.save(new Patient(req));

    }

    @Override
    @Transactional
    public Patient update(Patient req) {
        return patientRepo.save(new Patient(req));
    }

    @Override
    @Transactional
    public void delete(String id) {
        Optional<Patient> patientOpt = patientRepo.findById(id);

        patientOpt.ifPresentOrElse(patient -> {
            patientRepo.delete(patient);
        }, () -> {
            throw new ApplicationException("Patient ID cannot be found ", HttpStatus.NOT_FOUND);
        });
    }

}
