package com.konex.drogueria.controllers;

import com.konex.drogueria.dtos.SaleDTO;
import com.konex.drogueria.entities.Sale;
import com.konex.drogueria.services.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
@CrossOrigin("*")
public class SaleController {

    @Autowired
    private ISaleService iSaleService;

    @GetMapping("/{startDate}/{endDate}")
    public ResponseEntity<List<Sale>> findAllBySales(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {
        return new ResponseEntity<>(iSaleService.filterRangeDates(startDate, endDate), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sale> create(@RequestBody SaleDTO saleDTO) {
        return new ResponseEntity<>(iSaleService.sale(saleDTO), HttpStatus.OK);
    }
}
