package com.konex.drogueria.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_SALE")
    @SequenceGenerator(name = "SEQUENCE_SALE", sequenceName = "SEQUENCE_SALE", allocationSize = 1)
    private Long id;

    @Column(name = "createDate", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "America/Bogota")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createDate;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "medicine", nullable = false, foreignKey = @ForeignKey(name = "SALE_MEDICINE_FK"))
    private Medicine medicine;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "priceUnit", nullable = false)
    private double priceUnit;

    @Column(name = "priceTotal", nullable = false)
    private double priceTotal;
}
