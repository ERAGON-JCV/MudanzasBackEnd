package com.mudanzas.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.mudanzas.directriz.DirectrizControlDeTrazas;
import com.mudanzas.directriz.DirectrizProcesarInformacion;

@Controller
public class ProcesarInformacion implements DirectrizProcesarInformacion {

	private static Logger LOG = (Logger) LoggerFactory.getLogger(ProcesarInformacion.class);

	@Autowired
	private DirectrizControlDeTrazas directrizControlDeTrazas;

	public ProcesarInformacion(DirectrizControlDeTrazas directrizControlDeTrazas) {
		this.directrizControlDeTrazas = directrizControlDeTrazas;
	}

	public ProcesarInformacion() {
	}

	public Boolean bandera() {
		return true;
	}

	@Override
	public String obtenerResultadoMaximoDeViajes(MultipartFile file, String cedula) throws IOException {

		ArrayList<Integer> informacion = transformarInformacion(file);

		int dia = 0;
		int j;

		String resultadoCantidadDeViajesPorDia = "";

		for (int i = 1; i < informacion.size(); i++) {
			dia++;
			int cantidadItems = informacion.get(i);
			ArrayList<Integer> listadoPesoItemPorDia = new ArrayList<Integer>();

			for (j = i + 1; j <= (i + cantidadItems); j++) {
				listadoPesoItemPorDia.add(informacion.get(j));
			}
			listadoPesoItemPorDia = ordenarDeMayorAMenor(listadoPesoItemPorDia);

			String resultadoPorDia = "Case #" + dia + ": " + calcularViajesMaximos(listadoPesoItemPorDia);

			resultadoCantidadDeViajesPorDia += resultadoPorDia + "\n";

			i = j - 1;
		}
		LOG.info("Mandando a almacenar la traza");
		directrizControlDeTrazas.almacenarTraza(cedula);

		return resultadoCantidadDeViajesPorDia;

	}

	public ArrayList<Integer> transformarInformacion(MultipartFile file) throws IOException {

		InputStream inputStream = file.getInputStream();
		InputStreamReader isReader = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(isReader);
		String str;
		ArrayList<Integer> informacion = new ArrayList<Integer>();
		while ((str = reader.readLine()) != null) {
			informacion.add(Integer.parseInt(str.toString()));
		}
		return informacion;

	}

	public ArrayList<Integer> ordenarDeMayorAMenor(ArrayList<Integer> listadoPesoItemPorDia) {
		Comparator<Integer> comparador = Collections.reverseOrder();
		Collections.sort(listadoPesoItemPorDia, comparador);
		return listadoPesoItemPorDia;
	}

	public int calcularViajesMaximos(ArrayList<Integer> listadoPesoItemPorDia) {


		int pesoMaximo = listadoPesoItemPorDia.get(0);
		listadoPesoItemPorDia.remove(0);

		int pesoItem = 0;
		int i = 1;
		int viajesMaximos = 0;

		while (pesoItem < 50 && pesoMaximo < 50) {
			if (listadoPesoItemPorDia.size() == 0) {
				return 0;
			}
			listadoPesoItemPorDia.remove(listadoPesoItemPorDia.size() - 1);
			i++;
			pesoItem = pesoMaximo * i;
		}

		viajesMaximos++;

		if (listadoPesoItemPorDia.size() > 0) {
			viajesMaximos += calcularViajesMaximos(listadoPesoItemPorDia);
		}
		return viajesMaximos;
	}

}


