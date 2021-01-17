/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.service;

import com.nets.patientvisit.entity.Physician;
import java.util.List;

/**
 *
 * @author syahirghariff
 */
public interface PhysicianService {
    
    public List<Physician> findAll();

    public Physician save(Physician req);

    public Physician update(Physician req);

    public void delete(String id);
    
}
