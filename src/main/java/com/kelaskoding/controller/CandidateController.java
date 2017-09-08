/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.controller;

import com.kelaskoding.dto.SearchData;
import com.kelaskoding.entity.Candidate;
import com.kelaskoding.services.CandidateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hendro Steven
 */
@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
    
    @Autowired
    private CandidateService service;
    
    @RequestMapping(method = RequestMethod.POST)
    public Candidate insert(@RequestBody Candidate candidate) {
        return service.insert(candidate);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Candidate findById(@PathVariable String id) {
        return service.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public boolean deleteById(@PathVariable String id) {
        return service.delete(id);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Candidate> findAll() {
        return service.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public List<Candidate> findByName(@RequestBody SearchData searchData) {
        return service.findByName(searchData.getSearchKey());
    }
    
}
