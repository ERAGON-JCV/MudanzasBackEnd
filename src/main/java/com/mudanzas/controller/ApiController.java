package com.mudanzas.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mudanzas.directriz.DirectrizProcesarInformacion;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
public class ApiController {

	private static Logger LOG = (Logger) LoggerFactory.getLogger(ApiController.class);

	
	private DirectrizProcesarInformacion directrizProcesarInformacion;

	public ApiController(DirectrizProcesarInformacion directrizProcesarInformacion) {
		this.directrizProcesarInformacion = directrizProcesarInformacion;
	}


	@ResponseBody
	@PostMapping("/archivo/{cedula}")
	public String recibirArchivo(@RequestParam MultipartFile file, @PathVariable("cedula") String cedula)
			throws IOException {
		LOG.info("Recibiendo archivo y retornando resultados");

		return directrizProcesarInformacion.obtenerResultadoMaximoDeViajes(file, cedula);
	}

}
