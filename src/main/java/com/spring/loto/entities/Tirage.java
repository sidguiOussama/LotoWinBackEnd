package com.spring.loto.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Tirage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private int id;
	
	private int numeroTirage;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String jour;
	
	@ManyToOne
	@JoinColumn
	private Fichier fichier;

	@ManyToOne
	@JoinColumn
	private Combinaison combinaison;
	
	
	
	public Tirage() {
		super();
	}

	
	public Tirage(int numeroTirage, Date date, String jour, Fichier fichier, Combinaison combinaison) {
		super();
		this.numeroTirage = numeroTirage;
		this.date = date;
		this.jour = jour;
		this.fichier = fichier;
		this.combinaison = combinaison;
	}

	public Tirage(int id, int numeroTirage, Date date, String jour, Fichier fichier, Combinaison combinaison) {
		super();
		this.id = id;
		this.numeroTirage = numeroTirage;
		this.date = date;
		this.jour = jour;
		this.fichier = fichier;
		this.combinaison = combinaison;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroTirage() {
		return numeroTirage;
	}

	public void setNumeroTirage(int numeroTirage) {
		this.numeroTirage = numeroTirage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Fichier getFichier() {
		return fichier;
	}

	public void setFichier(Fichier fichier) {
		this.fichier = fichier;
	}

	public Combinaison getCombinaison() {
		return combinaison;
	}

	public void setCombinaison(Combinaison combinaison) {
		this.combinaison = combinaison;
	}
	
	
	
	
	
}
