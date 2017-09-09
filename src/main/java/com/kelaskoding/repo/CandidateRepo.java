/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.repo;

import com.kelaskoding.entity.Candidate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Hendro Steven
 */
public interface CandidateRepo extends CrudRepository<Candidate, String>{
    
    @Query("SELECT c FROM Candidate c")
    public List<Candidate> findAllCandidate();
    
    @Query("SELECT c FROM Candidate c WHERE LOWER(c.fullName) LIKE LOWER(:name)")
    public List<Candidate> findByName(@Param("name") String name);
    
}
