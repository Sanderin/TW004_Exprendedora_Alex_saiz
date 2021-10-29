package com.exprendedora;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Maquina2Test {

	@Before
	public void setUp() throws Exception {
		Maquina2 m = new Maquina2(0, 100, 100, null, 50); // id, caja, cambios, refresco
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void venderRefresco() {
		Refresco[] lista = new Refresco[5];
		lista[0] = new Refresco("fanta", "naranja", 2, 20);
		lista[1] = new Refresco("fanta", "limon", 3, 40);
		lista[2] = new Refresco("nestea", "melocoton", 3, 20);
		lista[3] = new Refresco("sprite", "limon", 2, 20);
		lista[4] = new Refresco("coca cola", "cola", 2, 50);
		Maquina2 m = new Maquina2(0, 100, 100, lista, 50);

		float espero = 3;
		float esperoCajaMaq = 102; // caja + ingreso - cambiosDevuelvo
		int esperoStock = 29;
		float respuesta = m.venta(5, 3);

		if (respuesta != espero)
			fail("Debería devolver 3€" + respuesta);

		if (esperoCajaMaq != m.getCaja())
			fail("La maquina debería tener 102€");

		if (esperoStock != lista[3].getStock() - 1)
			fail("Deberia faltar 1");
	}

	@Test
	public void reponerRefresco() {
		Refresco[] lista = new Refresco[5];
		lista[0] = new Refresco("fanta", "naranja", 2, 20);
		lista[1] = new Refresco("fanta", "limon", 3, 40);
		lista[2] = new Refresco("nestea", "melocoton", 3, 20);
		lista[3] = new Refresco("sprite", "limon", 2, 20);
		lista[4] = new Refresco("coca cola", "cola", 2, 50);
		Maquina2 m = new Maquina2(0, 100, 100, lista, 50);

		int esperoStock = 40;
		int add = 5;

		m.reponer(5, 1);
		if (esperoStock != lista[1].getStock()) {
			fail("deberian quedar " + esperoStock);
		}
	}

	@Test
	public void ComprobarNoSePasaLimiteRefescos() {
		
		Refresco[] lista = new Refresco[5];
		lista[0] = new Refresco("fanta", "naranja", 2, 20);
		lista[1] = new Refresco("fanta", "limon", 3, 40);
		lista[2] = new Refresco("nestea", "melocoton", 3, 20);
		lista[3] = new Refresco("sprite", "limon", 2, 20);
		lista[4] = new Refresco("coca cola", "cola", 2, 50);
		
		Maquina2 m = new Maquina2(0, 100, 100, lista, 50);
		int add = 555;

		m.reponer(add, 1);
		if (lista[1].getStock() > 50) {
			fail("el maximo es de " + m.getMaximo());
		}
	}

}
