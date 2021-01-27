/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.service;

import com.nets.patientvisit.entity.Visit;
import java.util.List;

/**
 *
 * @author syahirghariff
 */
public interface VisitService {
    
    public List<Visit> findAll();

    public Visit save(Visit req);

    public Visit update(Visit req);

    public void delete(String id);
    
    public Visit findById(String id);
    
    
    
}
