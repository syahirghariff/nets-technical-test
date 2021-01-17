/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.serviceimpl;

import com.nets.patientvisit.dao.PhysicianDao;
import com.nets.patientvisit.entity.Physician;
import com.nets.patientvisit.exception.DuplicateException;
import com.nets.patientvisit.service.HolidayService;
import com.nets.patientvisit.service.PhysicianService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class PhysicianServiceImpl implements PhysicianService {

    @Autowired
    private PhysicianDao physicianDao;

    @Autowired
    private HolidayService holidaySvc;

    @Override
    public List<Physician> findAll() {
        return physicianDao.findAll();
    }

    @Override
    @Transactional
    public Physician save(Physician req) {
        
        // Check for public holiday 
        holidaySvc.checkForHoliday();
        
        // Check for duplication ID
        this.checkForDuplicate(req);
        
        return physicianDao.saveOrUpdate(req);
    }

    @Override
    @Transactional
    public Physician update(Physician req) {
        
        // Check for public holiday 
        holidaySvc.checkForHoliday();
        
        return physicianDao.saveOrUpdate(req);
    }

    @Override
    @Transactional
    public void delete(String id) {
        
        // Check for public holiday 
        holidaySvc.checkForHoliday();
        
        physicianDao.deleteById(id);
    }

    private void checkForDuplicate(Physician req) {

        // Check if there's duplication in ID
        Physician physician = physicianDao.findById(req.getId());
        if (physician != null) {
            throw new DuplicateException(physician.getId());
        }
    }

}
