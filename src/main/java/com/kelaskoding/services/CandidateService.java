/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.services;

import com.kelaskoding.entity.Candidate;
import com.kelaskoding.repo.CandidateRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hendro Steven
 */
@Service("candidateService")
@Transactional
public class CandidateService {

    @Autowired
    private CandidateRepo repo;

    public Candidate insert(Candidate candidate) {
        return repo.save(candidate);
    }

    public Candidate findById(String id) {
        return repo.findOne(id);
    }

    public List<Candidate> findAll() {
        return repo.findAllCandidate();
    }

    public List<Candidate> findByName(String name) {
        return repo.findByName("%" + name + "%");
    }

    public boolean delete(String id) {
        repo.delete(id);
        return true;
    }
}
