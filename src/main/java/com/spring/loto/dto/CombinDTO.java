package com.spring.loto.dto;

import java.util.List;

public class CombinDTO {

	private List<Integer>valeurs;
	private int garantie;
	
	
	public CombinDTO() {
		// TODO Auto-generated constructor stub
	}
	public CombinDTO(List<Integer> valeurs, int garantie) {
		super();
		this.valeurs = valeurs;
		this.garantie = garantie;
	}
	public List<Integer> getValeurs() {
		return valeurs;
	}
	public void setValeurs(List<Integer> valeurs) {
		this.valeurs = valeurs;
	}
	public int getGarantie() {
		return garantie;
	}
	public void setGarantie(int garantie) {
		this.garantie = garantie;
	}
	
	
}
