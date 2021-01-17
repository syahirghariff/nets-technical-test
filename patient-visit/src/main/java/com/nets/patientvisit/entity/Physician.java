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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name = "PHYSICIAN")
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

    public Physician() {
    }
    
    public Physician(Physician req) {
    
        this.id = req.getId(); 
        this.name = req.getName();
        this.createdDate = req.getCreatedDate() != null ? req.getCreatedDate() : new Date(); 
        this.modifiedDate = new Date();
        this.modifiedBy = Constants.USERNAME;
        this.createdBy = Constants.USERNAME; 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "Physician{" + "id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + '}';
    }
    
}
