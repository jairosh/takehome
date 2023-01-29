package com.jjsh.takehome.dao;

import com.jjsh.takehome.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Payment, Long> {
}
