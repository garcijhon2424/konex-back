package com.konex.drogueria.controllers;

import com.konex.drogueria.dtos.MedicineDTO;
import com.konex.drogueria.entities.Medicine;
import com.konex.drogueria.services.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicine")
@CrossOrigin("*")
public class MedicineController {

    @Autowired
    private IMedicineService iMedicineService;

    @GetMapping("/{page}/{pageSize}")
    public ResponseEntity<MedicineDTO> findAll(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {
        return new ResponseEntity<>(iMedicineService.findAll(page, pageSize), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Medicine> create(@RequestBody Medicine medicine) {
        return new ResponseEntity<>(iMedicineService.create(medicine), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicine> update(@PathVariable("id") Long id, @RequestBody Medicine medicine) {
        return new ResponseEntity<>(iMedicineService.update(id, medicine), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Medicine> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iMedicineService.delete(id), HttpStatus.OK);
    }
}
