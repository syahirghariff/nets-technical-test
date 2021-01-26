/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.entity;

import com.nets.patientvisit.enums.Constants;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name = "PHYSICIAN")
@Getter @Setter @NoArgsConstructor
public class Physician implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    private String id; 
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date createdDate; 
    
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date modifiedDate; 
    
    @Column(name = "CREATED_BY")
    private String createdBy; 
    
    @Column(name = "MODIFIED_BY")
    private String modifiedBy; 
    
    public Physician(Physician req) {
    
        this.id = req.getId(); 
        this.name = req.getName();
        this.createdDate = req.getCreatedDate() != null ? req.getCreatedDate() : new Date(); 
        this.modifiedDate = new Date();
        this.modifiedBy = Constants.USERNAME;
        this.createdBy = Constants.USERNAME; 
    }

    @Override
    public String toString() {
        return "Physician{" + "id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + '}';
    }
    
}
