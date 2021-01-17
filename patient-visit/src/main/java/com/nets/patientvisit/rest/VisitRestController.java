/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.rest;

import com.nets.patientvisit.entity.Visit;
import com.nets.patientvisit.service.VisitService;
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
@RequestMapping("/visit")
public class VisitRestController {
    
    @Autowired
    private VisitService visitSvc;

    @GetMapping("/find_all")
    public ResponseEntity findAll() {

        try {
            return ResponseUtil.success(visitSvc.findAll());
        } catch (Exception error) {
            return ResponseUtil.exception(error);
        }
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody Visit req) {

        try {
            return ResponseUtil.success(visitSvc.save(req));
        } catch (Exception error) {
            return ResponseUtil.exception(error);
        }

    }
    
    @PostMapping("update")
    public ResponseEntity update(@RequestBody Visit req) {
        try {
            return ResponseUtil.success(visitSvc.update(req));
        } catch (Exception error) {
            return ResponseUtil.exception(error);
        }
    }
    
    @PostMapping("delete")
    public ResponseEntity save(@RequestBody String id) {

        try {
            visitSvc.delete(id);
            return ResponseUtil.success("Successfully delete");
        } catch (Exception error) {
            return ResponseUtil.exception(error);
        }

    }
    
}
