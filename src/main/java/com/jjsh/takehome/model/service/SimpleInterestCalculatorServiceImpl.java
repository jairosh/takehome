package com.jjsh.takehome.model.service;

import com.jjsh.takehome.model.InterestRequest;
import com.jjsh.takehome.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SimpleInterestCalculatorServiceImpl implements InterestCalculatorService{

    @Override
    public List<Payment> calculatePayments(InterestRequest request) {
        return null;
    }
}
