package com.konex.drogueria.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDTO {
    private Long medicineId;
    private int quantity;
    private double priceUnit;
    private double priceTotal;
}
