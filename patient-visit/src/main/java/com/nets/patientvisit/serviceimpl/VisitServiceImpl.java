/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.serviceimpl;

import com.nets.patientvisit.entity.Visit;
import com.nets.patientvisit.exception.ApplicationException;
import com.nets.patientvisit.repository.VisitRepository;
import com.nets.patientvisit.service.VisitService;
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
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepo;

    @Override
    public List<Visit> findAll() {
        return visitRepo.findAll();
    }

    @Override
    @Transactional
    public Visit save(Visit req) {

        // Check for duplicate ID
        visitRepo.findById(req.getId()).ifPresent(visit -> {
            throw new ApplicationException("Visit ID already exist: ".concat(visit.getId()), HttpStatus.CONFLICT);
        });

        return visitRepo.save(new Visit(req));
    }

    @Override
    @Transactional
    public Visit update(Visit req) {

        return visitRepo.save(new Visit(req));
    }

    @Override
    @Transactional
    public void delete(String id) {

        visitRepo.findById(id).ifPresentOrElse(visit -> {
            visitRepo.delete(visit);
        }, () -> {
            throw new ApplicationException("Visit ID cannot be found: ", HttpStatus.NOT_FOUND);
        });
    }

}
