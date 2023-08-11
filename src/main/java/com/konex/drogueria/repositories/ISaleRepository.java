package com.konex.drogueria.repositories;

import com.konex.drogueria.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {
    @Query(value = "SELECT * FROM sale WHERE TO_CHAR(CREATE_DATE, 'YYYY-MM-DD') BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Sale> findByRangeDates(String startDate, String endDate);
}


