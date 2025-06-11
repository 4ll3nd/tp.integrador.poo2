package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SordidaTest {
	Sordida sordida;
	@BeforeEach
	void setUp() throws Exception {
		sordida = new Sordida("Sordida");
	}

	@Test
	void testObtenerNombreDeEspecie() {
		assertEquals("Sordida", sordida.getNombre());
	}
}
