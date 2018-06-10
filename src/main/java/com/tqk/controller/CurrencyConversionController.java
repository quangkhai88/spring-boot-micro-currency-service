package com.tqk.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tqk.ForexConfiguration;
import com.tqk.entity.CurrencyConversionEntity;

/**
 *
 * @author khaitq on 9 juin 2018
 */

@RestController
@RibbonClient(name = "forex-service", configuration = ForexConfiguration.class)
public class CurrencyConversionController {

	@Autowired
	private RestTemplate restTemplate;

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionEntity convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionEntity> responseEntity = restTemplate.getForEntity(
				"http://forex-service/forex/from/{from}/to/{to}", CurrencyConversionEntity.class, uriVariables);

		CurrencyConversionEntity conversionEntity = responseEntity.getBody();

		return new CurrencyConversionEntity(conversionEntity.getId(), from, to, conversionEntity.getConversionValue(),
				quantity, quantity.multiply(conversionEntity.getConversionValue()), conversionEntity.getPort());
	}

}
