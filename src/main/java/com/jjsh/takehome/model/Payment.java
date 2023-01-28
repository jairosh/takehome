package com.jjsh.takehome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "RESPONSES")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JoinColumn(name = "requestid")
    @JsonIgnore
    private InterestRequest request;


    private Integer payment_number;
    private Double amount;
    private LocalDate payment_date;
}
