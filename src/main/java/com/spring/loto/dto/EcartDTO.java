package com.spring.loto.dto;

import java.util.Date;

public class EcartDTO {

	private int numero;
	private int max;
	private int min;
	
	public EcartDTO() {
	}
	public EcartDTO(int numero, int max, int min) {
		super();
		this.numero = numero;
		this.max = max;
		this.min = min;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	@Override
	public String toString() {
		return "EcartDTO [numero=" + numero + ", max=" + max + ", min=" + min + "]";
	}
	
	
}
