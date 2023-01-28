package com.jjsh.takehome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
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
