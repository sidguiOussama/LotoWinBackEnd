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
	
	
	private int bouleOne;
	private int bouleTwo;
	private int bouleThree;
	private int bouleFour;
	private int bouleFive;
	private int numeroChance;
	
	public Combinaison() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getBouleOne() {
		return bouleOne;
	}

	public void setBouleOne(int bouleOne) {
		this.bouleOne = bouleOne;
	}

	public int getBouleTwo() {
		return bouleTwo;
	}

	public void setBouleTwo(int bouleTwo) {
		this.bouleTwo = bouleTwo;
	}

	public int getBouleThree() {
		return bouleThree;
	}

	public void setBouleThree(int bouleThree) {
		this.bouleThree = bouleThree;
	}

	public int getBouleFour() {
		return bouleFour;
	}

	public void setBouleFour(int bouleFour) {
		this.bouleFour = bouleFour;
	}

	public int getBouleFive() {
		return bouleFive;
	}

	public void setBouleFive(int bouleFive) {
		this.bouleFive = bouleFive;
	}

	public int getNumeroChance() {
		return numeroChance;
	}

	public void setNumeroChance(int numeroChance) {
		this.numeroChance = numeroChance;
	}

	public Combinaison(Integer id, int bouleOne, int bouleTwo, int bouleThree, int bouleFour, int bouleFive,
			int numeroChance) {
		super();
		this.id = id;
		this.bouleOne = bouleOne;
		this.bouleTwo = bouleTwo;
		this.bouleThree = bouleThree;
		this.bouleFour = bouleFour;
		this.bouleFive = bouleFive;
		this.numeroChance = numeroChance;
	}

	public Combinaison(int bouleOne, int bouleTwo, int bouleThree, int bouleFour, int bouleFive, int numeroChance) {
		super();
		this.bouleOne = bouleOne;
		this.bouleTwo = bouleTwo;
		this.bouleThree = bouleThree;
		this.bouleFour = bouleFour;
		this.bouleFive = bouleFive;
		this.numeroChance = numeroChance;
	}

	@Override
	public String toString() {
		return "Combinaison [id=" + id + ", bouleOne=" + bouleOne + ", bouleTwo=" + bouleTwo + ", bouleThree="
				+ bouleThree + ", bouleFour=" + bouleFour + ", bouleFive=" + bouleFive + ", numeroChance="
				+ numeroChance + "]";
	}
	
	
	
}
