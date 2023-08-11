package com.konex.drogueria.services;

import com.konex.drogueria.dtos.SaleDTO;
import com.konex.drogueria.entities.Sale;

import java.util.List;

public interface ISaleService {
    Sale sale(SaleDTO saleDTO);

    List<Sale> filterRangeDates(String startDate, String endDate);
}
