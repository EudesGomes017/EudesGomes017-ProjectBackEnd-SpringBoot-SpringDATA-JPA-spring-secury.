package com.EudesGomes.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.EudesGomes.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	/*seleciona todos os objeto obj do tipo Sale obj só quero as vendas onde(where)
	 a data do obj esteja entre(BETWEEN) minimu e max. ordernar o resultado por 
	 valor da venda descrescente  */
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
}
