/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nets.patientvisit.enums.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createdDate; 
    
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date modifiedDate; 
    
    @Column(name = "CREATED_BY")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdBy; 
    
    @Column(name = "MODIFIED_BY")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String modifiedBy; 
    
    public Physician(Physician req) {
    
        this.id = req.getId(); 
        this.name = req.getName();
        this.createdDate = req.getCreatedDate() != null ? req.getCreatedDate() : new Date(); 
        this.modifiedDate = new Date();
        this.modifiedBy = Constants.USERNAME;
        this.createdBy = Constants.USERNAME; 
    }
    
    public Physician setPhysician(Physician req ) {
        Physician physician = new Physician();
        physician.id = req.getId(); 
        physician.name = req.getName(); 
        
        return physician;
    }
    
    public static List<Physician> setPhysicianList (List<Physician> req){
    
    
        List<Physician> res = new ArrayList<>(); 
        
        req.stream().forEach(physician -> {
        
            Physician phy = new Physician();
            phy.setId(physician.getId());
            phy.setName(physician.getName());
            
            res.add(phy);
            
        });
        
        return res;
        
    }

    @Override
    public String toString() {
        return "Physician{" + "id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + '}';
    }
    
}
