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
		Maquina m = new Maquina(0, 100, 100, null, 50); // id, caja, cambios, refresco
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void venderRefresco() {
		Refresco r = new Refresco("coca cola", "cola", 2f, 30); // nombre, sabor, precio, cantidad
		Maquina m = new Maquina(0, 100, 100, r, 50);

		float espero = 3;
		float esperoCajaMaq = 102; // caja + ingreso - cambiosDevuelvo
		int esperoStock = 29;
		float respuesta = m.venta(5);

		if (respuesta != espero)
			fail("Debería devolver 3€" + respuesta);

		if (esperoCajaMaq != m.getCaja())
			fail("La maquina debería tener 102€");

		if (esperoStock != r.getStock() - 1)
			fail("Deberia faltar 1");
	}

	@Test
	public void reponerRefresco() {
		Refresco r = new Refresco("coca cola", "cola", 2f, 30);
		Maquina m = new Maquina(0, 100, 100, r, 50);

		int esperoStock = 35;
		int add = 5;

		m.reponer(add);
		if (esperoStock != r.getStock()) {
			fail("deberian quedar " + esperoStock);
		}

	}

	@Test
	public void ComprobarNoSePasaLimiteRefescos() {
		Refresco r = new Refresco("coca cola", "cola", 2f, 30);
		Maquina m = new Maquina(0, 100, 100, r, 50);

		int add = 555;

		m.reponer(add);
		if (r.getStock() > 50) {
			fail("el maximo es de " + m.getMaximo());
		}

	}

}
