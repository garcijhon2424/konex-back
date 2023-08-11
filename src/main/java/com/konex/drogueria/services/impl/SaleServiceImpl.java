package com.konex.drogueria.services.impl;

import com.konex.drogueria.dtos.SaleDTO;
import com.konex.drogueria.entities.Medicine;
import com.konex.drogueria.entities.Sale;
import com.konex.drogueria.repositories.ISaleRepository;
import com.konex.drogueria.services.IMedicineService;
import com.konex.drogueria.services.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    private ISaleRepository iSaleRepository;

    @Autowired
    private IMedicineService iMedicineService;

    @Override
    public Sale sale(SaleDTO saleDTO) {
        Sale sale = Sale
                .builder()
                .createDate(Calendar.getInstance())
                .quantity(saleDTO.getQuantity())
                .priceUnit(saleDTO.getPriceUnit())
                .priceTotal(saleDTO.getPriceTotal())
                .medicine(Medicine.builder().id(saleDTO.getMedicineId()).build())
                .build();

        Sale saleReturn = iSaleRepository.save(sale);

        Medicine medicine = iMedicineService.updateInventory(saleDTO);

        return medicine != null ? saleReturn : null;
    }

    @Override
    public List<Sale> filterRangeDates(String startDate, String endDate) {
        return iSaleRepository.findByRangeDates(startDate, endDate);
    }
}
