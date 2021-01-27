/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.serviceimpl;

import com.nets.patientvisit.entity.Physician;
import com.nets.patientvisit.exception.ApplicationException;
import com.nets.patientvisit.repository.PhysicianRepository;
import com.nets.patientvisit.service.PhysicianService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class PhysicianServiceImpl implements PhysicianService {

    @Autowired
    private PhysicianRepository physicianRepo;

    @Override
    public List<Physician> findAll() {
        return physicianRepo.findAll();
    }

    @Override
    @Transactional
    public Physician save(Physician req) {

        // Check for duplication ID
        physicianRepo.findById(req.getId()).ifPresent(physician -> {
            throw new ApplicationException("Physician ID already exist: ".concat(physician.getId()), HttpStatus.CONFLICT);
        });

        return physicianRepo.save(new Physician(req));
    }

    @Override
    @Transactional
    public Physician update(Physician req) {

        return physicianRepo.save(new Physician(req));
    }

    @Override
    @Transactional
    public void delete(String id) {

        physicianRepo.findById(id).ifPresentOrElse(physician -> {
            physicianRepo.delete(physician);
        }, () -> {
            throw new ApplicationException("Physician id cannot be found", HttpStatus.NOT_FOUND);
        });

    }

    @Override
    public Physician findById(String id) {
        return physicianRepo.findById(id).get();
    }

    @Override
    public List<Physician> findPhysician() {
        return Physician.setPhysicianList(this.findAll());
    }
    
    
    
    
    
}
