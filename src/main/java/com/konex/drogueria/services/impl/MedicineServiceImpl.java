package com.konex.drogueria.services.impl;

import com.konex.drogueria.dtos.MedicineDTO;
import com.konex.drogueria.dtos.SaleDTO;
import com.konex.drogueria.entities.Medicine;
import com.konex.drogueria.repositories.IMedicineRepository;
import com.konex.drogueria.services.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicineServiceImpl implements IMedicineService {

    @Autowired
    private IMedicineRepository iMedicineRepository;

    @Override
    public MedicineDTO findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Medicine> medicinePage = iMedicineRepository.findAll(pageable);

        return MedicineDTO.builder().list(medicinePage.getContent()).totalCount(medicinePage.getTotalElements()).build();
    }

    @Override
    public Medicine findById(Long id) {
        return iMedicineRepository.findById(id).orElse(null);
    }

    @Override
    public Medicine create(Medicine medicine) {
        medicine.setId(null);
        return iMedicineRepository.save(medicine);
    }

    @Override
    public Medicine update(Long id, Medicine medicine) {
        Optional<Medicine> search = iMedicineRepository.findById(id);
        medicine.setId(id);
        return search.isPresent() ? iMedicineRepository.save(medicine) : null;
    }

    @Override
    public Medicine delete(Long id) {
        Optional<Medicine> search = iMedicineRepository.findById(id);
        if (search.isPresent()) {
            iMedicineRepository.deleteById(id);
        }
        return search.orElse(null);
    }

    @Override
    public Medicine updateInventory(SaleDTO saleDTO) {
        Medicine medicine = findById(saleDTO.getMedicineId());

        if (medicine == null) return null;

        medicine.setStock(medicine.getStock() - saleDTO.getQuantity());

        return iMedicineRepository.save(medicine);
    }
}
