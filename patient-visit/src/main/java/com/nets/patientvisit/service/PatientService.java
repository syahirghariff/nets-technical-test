/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.service;

import com.nets.patientvisit.entity.Patient;
import java.util.List;

/**
 *
 * @author syahirghariff
 */
public interface PatientService {
    
    public List<Patient> findAll(); 
    
    public Patient save(Patient req);
    
    public Patient update(Patient req); 
    
    public Patient findById (String id);
    
    public void delete(String id);
    
}
