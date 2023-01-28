package com.jjsh.takehome.service;

import com.jjsh.takehome.model.InterestRequest;
import com.jjsh.takehome.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SimpleInterestCalculatorServiceImpl implements InterestCalculatorService{

    /**
     * Creates a detailed list of weekly payments for a loan
     * @param request The loan request, includes principal, a yearly rate and payment terms
     * @return A list of installments
     */
    @Override
    public List<Payment> calculatePayments(InterestRequest request) {
        List<Payment> thePayments = new ArrayList<>();
        Double weeklyPayment = calculateWeeklyPayment(request.getAmount(), request.getRate(), request.getTerms());

        LocalDate today = LocalDate.now();
        LocalDate paymentDate = today.plusWeeks(1);

        for(int i=1; i<= request.getTerms(); i++){
            Payment payment = Payment.builder()
                    .payment_date(paymentDate)
                    .id(null)
                    .payment_number(i)
                    .amount(weeklyPayment)
                    .build();

            paymentDate = paymentDate.plusWeeks(1);
            thePayments.add(payment);
        }
        return thePayments;
    }

    /**
     * Calculates the payments for a simple interest loan, calculated in weekly payments and a yearly rate
     * @param principal The loan amount
     * @param rate The interest rate per year
     * @param weeks The number of weeks for the loan
     * @return How much the weekly payment must be
     */
    private Double calculateWeeklyPayment(Double principal, Double rate, Integer weeks){
        Double totalCost = principal * (1 + (rate * (weeks / 52.0)));
        return totalCost / weeks;
    }
}
