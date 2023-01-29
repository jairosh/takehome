package com.jjsh.takehome.dao;

import com.jjsh.takehome.model.InterestRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<InterestRequest, Long> {

}
