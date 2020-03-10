package com.mudanzas.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mudanzas.directriz.DirectrizControlDeTrazas;
import com.mudanzas.entity.Traza;
import com.mudanzas.repository.ITrazaRepository;

@Controller
public class ControlDeTrazas implements DirectrizControlDeTrazas {
	private static Logger LOG = (Logger) LoggerFactory.getLogger(ControlDeTrazas.class);

	@Autowired
	private ITrazaRepository repositorio;
	

	public ControlDeTrazas(ITrazaRepository repositorio) {
		this.repositorio = repositorio;
	}




	public ControlDeTrazas() {
		
	}




	@Override
	public boolean almacenarTraza(String cedula) {
		try {
			repositorio.save(new Traza(cedula, new Date()));
			LOG.info("Traza almacenada correctamente");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
