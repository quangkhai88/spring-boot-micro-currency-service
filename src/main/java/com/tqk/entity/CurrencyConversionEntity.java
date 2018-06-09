package com.tqk.entity;

import java.math.BigDecimal;

/**
*	@author khaitq
*/

public class CurrencyConversionEntity {
	
	public CurrencyConversionEntity() {

	}

	private Long id;
	
	private String from;
	
	private String to;

	private BigDecimal conversionValue;
	
	private BigDecimal quantity;
	
	private BigDecimal total;
	
	private int port;

	
	public CurrencyConversionEntity(Long id, String from, String to, BigDecimal conversion, BigDecimal quantity,
			BigDecimal total, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionValue = conversion;
		this.quantity = quantity;
		this.total = total;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}


	public BigDecimal getConversionValue() {
		return conversionValue;
	}

	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}


