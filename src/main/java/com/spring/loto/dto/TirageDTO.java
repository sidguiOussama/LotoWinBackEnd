package com.spring.loto.dto;

import java.util.Date;

public class TirageDTO {

	private Date datedebut;
	private Date dateFin;
	private int nombre;
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public TirageDTO(Date datedebut, Date dateFin, int nombre) {
		super();
		this.datedebut = datedebut;
		this.dateFin = dateFin;
		this.nombre = nombre;
	}
	TirageDTO(int nombre){
		this.nombre = nombre;
	}
	public TirageDTO() {
	}
	@Override
	public String toString() {
		return "TirageDTO [datedebut=" + datedebut + ", dateFin=" + dateFin + ", nombre=" + nombre + "]";
	}
	
}
