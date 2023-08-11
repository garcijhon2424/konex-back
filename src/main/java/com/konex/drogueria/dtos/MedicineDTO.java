package com.konex.drogueria.dtos;

import com.konex.drogueria.entities.Medicine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicineDTO {
    List<Medicine> list;
    long totalCount;
}
