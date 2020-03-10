package com.mudanzas;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mudanzas.controller.ControlDeTrazas;
import com.mudanzas.controller.ProcesarInformacion;
import com.mudanzas.directriz.DirectrizControlDeTrazas;
import com.mudanzas.repository.ITrazaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiRestMudanzasApplicationTests {

	@Autowired
	private ControlDeTrazas ct;
	@Autowired
	private ITrazaRepository repositorio;
	@Autowired
	private ProcesarInformacion pI;

	@Autowired
	private DirectrizControlDeTrazas directrizControlDeTrazas;

	@Test
	public void almacenarTrazaTest() {
		ct = new ControlDeTrazas(repositorio);
		assertTrue(ct.almacenarTraza("1215"));
	}

	@Test
	public void prueba() {
		pI = new ProcesarInformacion(directrizControlDeTrazas);
		ArrayList<Integer> listadoPesoItemPorDia = new ArrayList<Integer>();
		listadoPesoItemPorDia.add(30);
		listadoPesoItemPorDia.add(30);
		listadoPesoItemPorDia.add(1);
		listadoPesoItemPorDia.add(1);

		assertEquals(2, pI.calcularViajesMaximos(listadoPesoItemPorDia));

	}

}
