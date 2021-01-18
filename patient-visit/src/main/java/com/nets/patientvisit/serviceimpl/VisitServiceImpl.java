/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.serviceimpl;

import com.nets.patientvisit.dao.VisitDao;
import com.nets.patientvisit.entity.Visit;
import com.nets.patientvisit.exception.DuplicateException;
import com.nets.patientvisit.service.HolidayService;
import com.nets.patientvisit.service.VisitService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class VisitServiceImpl implements VisitService {
    
    @Autowired
    private VisitDao visitDao;
    
    @Autowired
    private HolidayService holidaySvc;

    @Override
    public List<Visit> findAll() {
        return visitDao.findAll();
    }

    @Override
    @Transactional
    public Visit save(Visit req) {
        
        
        // Check for holiday 
        holidaySvc.checkForHoliday();
        
        // Check for duplicate ID
        this.checkForDuplicate(req);
        
        Visit visit = visitDao.saveOrUpdate(req);
        
        return visitDao.findById(visit.getId());
    }

    @Override
    @Transactional
    public Visit update(Visit req) {
        
        // Check for holiday 
        holidaySvc.checkForHoliday();
        
        
        return visitDao.saveOrUpdate(req);
    }

    @Override
    @Transactional
    public void delete(String id) {
        
        // Check for holiday 
        holidaySvc.checkForHoliday();
        
        visitDao.deleteById(id);
        
    }
    
    
    private void checkForDuplicate(Visit req) {

        // Check if there's duplication in ID
        Visit physician = visitDao.findById(req.getId());
        if (physician != null) {
            throw new DuplicateException(physician.getId());
        }
    }
    
    
    
    
}
