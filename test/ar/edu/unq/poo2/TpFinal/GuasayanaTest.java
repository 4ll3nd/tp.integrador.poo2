package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuasayanaTest {
	Guasayana guasayana;
	@BeforeEach
	void setUp() throws Exception {
		guasayana = new Guasayana("guasayana");
	}

	@Test
	void testObtenerNombreDeEspecie() {
		assertEquals("guasayana", guasayana.getNombre());
	}
}
