/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.rest;

import com.nets.patientvisit.entity.Physician;
import com.nets.patientvisit.service.PhysicianService;
import com.nets.patientvisit.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author syahirghariff
 */

@RestController
@RequestMapping("/physician")
public class PhysicianRestController {
    
    @Autowired
    private PhysicianService physicianSvc;
    
    
    @GetMapping("/find-all")
    public ResponseEntity findAll() {

        try {
            return ResponseUtil.success(physicianSvc.findAll());
        } catch (Exception error) {
            return ResponseUtil.exception(error);
        }
    }
    
    @GetMapping("/find-physician-list")
    public ResponseEntity findPhysicianList() {

        try {
            return ResponseUtil.success(physicianSvc.findPhysician());
        } catch (Exception error) {
            return ResponseUtil.exception(error);
        }
    }
    
    
    @PostMapping("save")
    public ResponseEntity save(@RequestBody Physician req) {

        try {
            return ResponseUtil.success(physicianSvc.save(req));
        } catch (Exception error) {
            return ResponseUtil.exception(error);
        }

    }
    
    @PostMapping("find-by-id")
    public ResponseEntity findById(@RequestBody String id) {
        try {
            return ResponseUtil.success(physicianSvc.findById(id));
        } catch (Exception error) {
            return ResponseUtil.exception(error);
        }
    }
    
    @PostMapping("update")
    public ResponseEntity update(@RequestBody Physician req) {
        try {
            return ResponseUtil.success(physicianSvc.update(req));
        } catch (Exception error) {
            return ResponseUtil.exception(error);
        }
    }
    
    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody String id) {

        try {
            physicianSvc.delete(id);
            return ResponseUtil.success("Successfully delete");
        } catch (Exception error) {
            return ResponseUtil.exception(error);
        }

    }
    
    
}
