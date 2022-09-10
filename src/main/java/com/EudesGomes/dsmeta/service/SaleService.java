package com.EudesGomes.dsmeta.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.EudesGomes.dsmeta.entities.Sale;
import com.EudesGomes.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	/*
	 * metodo retorno do repostiry por id
	public List<Sale> findSales() {
		return repository.findAll();
	}*/
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		//criar uma data com dia de hoje 
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		//convertendo de a data de string para formato data
		LocalDate min = minDate.equals("") ? today.minusDays(365) :  LocalDate.parse(minDate);
		//condição ternario 
		LocalDate max = maxDate.equals("") ? today :  LocalDate.parse(maxDate);
		
		
		return repository.findSales(min, max, pageable);
	}

}
