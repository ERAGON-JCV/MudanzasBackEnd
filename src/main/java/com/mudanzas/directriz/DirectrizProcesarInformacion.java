package com.mudanzas.directriz;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface DirectrizProcesarInformacion {
	
	
	public String obtenerResultadoMaximoDeViajes(MultipartFile file, String cedula) throws IOException;
	

}
