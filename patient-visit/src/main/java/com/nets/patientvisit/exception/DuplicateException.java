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
public class DuplicateException extends RuntimeException {
    
    public static String DUPPLICATE_ID_MESSAGE = "There is existing record of ID: ";
    
    public DuplicateException(){};
    
    public DuplicateException(String id) {
        super(DUPPLICATE_ID_MESSAGE.concat(id));
    }
    
}
