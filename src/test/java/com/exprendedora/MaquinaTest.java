package com.exprendedora;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaquinaTest {

	

	@Before
	public void setUp() throws Exception {
		Maquina m = new Maquina(0, 100, 100, null); // id, caja, cambios, refresco
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void venderRefresco() {
		Refresco r = new Refresco("coca cola", "cola", 2f, 30);
		Maquina m = new Maquina(0, 100, 100, r);

		float espero = 3;
		float esperoCajaMaq = 102; // caja + ingreso - cambiosDevuelvo
		int esperoStock = 29;
		float respuesta = m.venta(5);

		if (respuesta != espero)
			fail("Debería devolver 3€" + respuesta);

		if (esperoCajaMaq != m.getCaja())
			fail("La maquina debería tener 102€");

		if (esperoStock != r.getStock()-1)
			fail("Deberia faltar 1");

	}

}
