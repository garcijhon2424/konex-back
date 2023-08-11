package com.konex.drogueria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_MEDICINE")
    @SequenceGenerator(name = "SEQUENCE_MEDICINE", sequenceName = "SEQUENCE_MEDICINE", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lab", nullable = false)
    private String lab;

    @Column(name = "createDate", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    private LocalDate createDate;

    @Column(name = "dueDate", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    private LocalDate dueDate;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "price", nullable = false)
    private double value;
}
