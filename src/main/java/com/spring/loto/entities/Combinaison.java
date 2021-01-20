package com.spring.loto.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Combinaison implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Integer id;
	
	private int boule1;
	private int boule2;
	private int boule3;
	private int boule4;
	private int boule5;
	private int numeroChance;
	
	public Combinaison() {
		
	}
	public Combinaison(Integer id, int boule1, int boule2, int boule3, int boule4, int boule5, int numeroChance) {
		super();
		this.id = id;
		this.boule1 = boule1;
		this.boule2 = boule2;
		this.boule3 = boule3;
		this.boule4 = boule4;
		this.boule5 = boule5;
		this.numeroChance = numeroChance;
	}
	
	public Combinaison(int boule1, int boule2, int boule3, int boule4, int boule5, int numeroChance) {
		super();
		this.boule1 = boule1;
		this.boule2 = boule2;
		this.boule3 = boule3;
		this.boule4 = boule4;
		this.boule5 = boule5;
		this.numeroChance = numeroChance;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getBoule1() {
		return boule1;
	}
	public void setBoule1(int boule1) {
		this.boule1 = boule1;
	}
	public int getBoule2() {
		return boule2;
	}
	public void setBoule2(int boule2) {
		this.boule2 = boule2;
	}
	public int getBoule3() {
		return boule3;
	}
	public void setBoule3(int boule3) {
		this.boule3 = boule3;
	}
	public int getBoule4() {
		return boule4;
	}
	public void setBoule4(int boule4) {
		this.boule4 = boule4;
	}
	public int getBoule5() {
		return boule5;
	}
	public void setBoule5(int boule5) {
		this.boule5 = boule5;
	}
	public int getNumeroChance() {
		return numeroChance;
	}
	public void setNumeroChance(int numeroChance) {
		this.numeroChance = numeroChance;
	}
	
	
}
