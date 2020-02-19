package com.mudanzas.model;

import java.util.Date;


public class TrazaModel {

	public TrazaModel(long id, String cedulaEjecutor, Date fechaEjecucion) {
		this.id = id;
		this.cedulaEjecutor = cedulaEjecutor;
		this.fechaEjecucion = fechaEjecucion;
	}

	public TrazaModel() {
	}

//	public TrazaModel(Traza traza) {
//		this.id = traza.getId();
//		this.cedulaEjecutor = traza.getCedulaEjecutor();
//		this.fechaEjecucion = traza.getFechaEjecucion();
//
//	}

	private long id;
	private String cedulaEjecutor;
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
