package com.jjsh.takehome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "REQUESTS")
public class InterestRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @NotNull
    @NotBlank
    @DecimalMax("999999.0")
    @DecimalMin("1.0")
    @Column(name = "amount")
    private Double amount;

    @NotNull
    @NotBlank
    @DecimalMax("1.0")
    @DecimalMin("0.01")
    @Column(name="rate")
    private Double rate;

    @Max(52)
    @Min(4)
    @NotNull @NotBlank
    @Column(name = "terms")
    private Integer terms;
}
