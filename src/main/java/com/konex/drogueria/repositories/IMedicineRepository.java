package com.konex.drogueria.repositories;

import com.konex.drogueria.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicineRepository extends JpaRepository<Medicine, Long> {

}
