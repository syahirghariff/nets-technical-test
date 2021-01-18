/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nets.patientvisit.enums.Constants;
import com.nets.patientvisit.enums.GenderEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "PATIENT")
public class Patient implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    private String id; 
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "AGE")
    private Integer age; 
    
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender; 
    
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date createdDate; 
    
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date modifiedDate; 
    
    @Column(name = "CREATED_BY")
    private String createdBy; 

    public Patient() {
    }
    
    public Patient(Patient req){
        
       this.id = req.getId().trim(); 
       this.name = req.getName().trim();
       this.age = req.getAge(); 
       this.gender = req.getGender(); 
       this.createdDate = req.getCreatedDate() != null ? req.getCreatedDate() : new Date();
       this.modifiedDate = new Date();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
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

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy + '}';
    }
    
    
    
    
    
    
    
}
