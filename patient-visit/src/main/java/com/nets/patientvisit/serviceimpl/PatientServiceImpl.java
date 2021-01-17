/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.serviceimpl;

import com.nets.patientvisit.dao.PatientDao;
import com.nets.patientvisit.entity.Patient;
import com.nets.patientvisit.exception.DuplicateException;
import com.nets.patientvisit.service.HolidayService;
import com.nets.patientvisit.service.PatientService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private HolidayService holidaySvc;

    @Override
    public List<Patient> findAll() {
        return patientDao.findAll();
    }

    @Override
    @Transactional
    public Patient save(Patient req) {

        // Check for public holiday 
        holidaySvc.checkForHoliday();

        // Check for duplication ID
        this.checkForDuplicate(req);

        return patientDao.saveOrUpdate(req);

    }

    @Override
    @Transactional
    public Patient update(Patient req) {
        
        // Check for public holiday 
        holidaySvc.checkForHoliday();
        
        return patientDao.saveOrUpdate(req);

    }

    @Override
    @Transactional
    public void delete(String id) {
        
        // Check for public holiday 
        holidaySvc.checkForHoliday();
        
        patientDao.deleteById(id);
    }

    private void checkForDuplicate(Patient req) {

        // Check if there's duplication in ID
        Patient patient = patientDao.findById(req.getId());
        if (patient != null) {
            throw new DuplicateException(patient.getId());
        }
    }

}
