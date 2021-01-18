/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.exception;

/**
 *
 * @author syahirghariff
 */
public class MissingException extends RuntimeException{
    
    private static final String MISSING_MSG = "No Application Found"; 
    
    public MissingException() {
        super(MISSING_MSG);
    }
    
}
