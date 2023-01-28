package com.jjsh.takehome.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jjsh.takehome.model.InterestRequest;
import com.jjsh.takehome.model.Payment;
import com.jjsh.takehome.service.InterestCalculatorService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for the Simple Interest Simulator
 */
@RestController
@Slf4j
public class CalculatorController {

    @Autowired
    InterestCalculatorService calculatorService;

    @PostMapping("/interest")
    @JsonSerialize
    public List<Payment> paymentsWithSimpleInterest(@Valid @RequestBody InterestRequest request){
        log.info("New request");
        List<Payment> payments = calculatorService.calculatePayments(request);
        log.debug("There were " + payments.size() + " payments");
        return payments;
    }
}
