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
		Maquina2 m = new Maquina2(0, 100, 100, null); // id, caja, cambios, refresco
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
		Maquina2 m = new Maquina2(0, 100, 100, lista);

		float espero = 3;
		float esperoCajaMaq = 102; // caja + ingreso - cambiosDevuelvo
		int esperoStock = 29;
		float respuesta = m.venta(5, 3);

		if (respuesta != espero)
			fail("Debería devolver 3€" + respuesta);

		if (esperoCajaMaq != m.getCaja())
			fail("La maquina debería tener 102€");

		if (esperoStock != lista[3].getStock()-1)
			fail("Deberia faltar 1");

	}

}
