package com.jjsh.takehome.service;

import com.jjsh.takehome.model.InterestRequest;
import com.jjsh.takehome.model.Payment;

import java.util.List;

public interface InterestCalculatorService {
    List<Payment> calculatePayments(InterestRequest request);
}
