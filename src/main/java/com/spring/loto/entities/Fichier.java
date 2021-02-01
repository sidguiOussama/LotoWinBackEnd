package com.spring.loto.entities;

import java.io.Serializable;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fichier implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue 
	@Id 
	private Integer id;
	private String nomFichier;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomFichier() {
		return nomFichier;
	}
	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}
	public Fichier() {
		super();
	}
	public Fichier(Integer id, String nomFichier) {
		super();
		this.id = id;
		this.nomFichier = nomFichier;
	}
	
	public Fichier(String nomFichier) {
		super();
		this.nomFichier = nomFichier;
	}
	@Override
	public String toString() {
		return "Fichier [id=" + id + ", nomFichier=" + nomFichier + "]";
	}
	
	
}
