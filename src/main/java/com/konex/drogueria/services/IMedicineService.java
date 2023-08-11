package com.konex.drogueria.services;

import com.konex.drogueria.dtos.MedicineDTO;
import com.konex.drogueria.dtos.SaleDTO;
import com.konex.drogueria.entities.Medicine;

public interface IMedicineService {
    MedicineDTO findAll(int page, int pageSize);

    Medicine findById(Long id);

    Medicine create(Medicine medicine);

    Medicine update(Long id, Medicine medicine);

    Medicine delete(Long id);

    Medicine updateInventory(SaleDTO saleDTO);
}
