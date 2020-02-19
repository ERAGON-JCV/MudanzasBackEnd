package com.mudanzas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Traza {

	public Traza() {
	}

	public Traza( String cedulaEjecutor, Date fecha) {
		this.cedulaEjecutor = cedulaEjecutor;
		this.fechaEjecucion = fecha;
	}

	@GeneratedValue
	@Id
	@Column
	private long id;

	@Column
	private String cedulaEjecutor;

	@Column
	private Date fechaEjecucion;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCedulaEjecutor() {
		return cedulaEjecutor;
	}

	public void setCedulaEjecutor(String cedulaEjecutor) {
		this.cedulaEjecutor = cedulaEjecutor;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

}
