package com.EudesGomes.dsmeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.EudesGomes.dsmeta.entities.Sale;
import com.EudesGomes.dsmeta.service.SaleService;
import com.EudesGomes.dsmeta.service.SmsService;

@RestControllerAdvice
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService sms;
	
	/* metodo busca por todos os id
	 * @GetMapping
	public List<Sale> findSales() {
		return service.findSales();
	}*/
	//metodo consulta por data
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,  
			Pageable pageable) {
		return service.findSales(minDate, maxDate, pageable);
	}
	
	//metodo que enviar os sms
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		sms.sendSms(id);
	}
}