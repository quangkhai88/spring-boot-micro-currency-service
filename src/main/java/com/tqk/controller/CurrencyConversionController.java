package com.tqk.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tqk.entity.CurrencyConversionEntity;

/**
*
* @author khaitq on 9 juin 2018
*/

@RestController
public class CurrencyConversionController {
	
	
	@RequestMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionEntity convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		
		Map<String, String> uriVariables = new HashMap<String, String>();
	    uriVariables.put("from", from);
	    uriVariables.put("to", to);

		
	    ResponseEntity<CurrencyConversionEntity> responseEntity = new RestTemplate().getForEntity(
	            "http://localhost:8090/forex/from/{from}/to/{to}", CurrencyConversionEntity.class, uriVariables);		
		
	    CurrencyConversionEntity conversionEntity = responseEntity.getBody();
	    
	    return new CurrencyConversionEntity(conversionEntity.getId(),
	    				from, to, 
	    				conversionEntity.getConversionValue(),
	    				quantity,
	    				quantity.multiply(conversionEntity.getConversionValue()),
	    				conversionEntity.getPort());
	}

}


