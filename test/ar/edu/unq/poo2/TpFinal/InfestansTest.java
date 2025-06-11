package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InfestansTest {
	Infestans infestans;
	@BeforeEach
	void setUp() throws Exception {
		infestans = new Infestans("Infestans");
	}

	@Test
	void testObtenerNombreDeEspecie() {
		assertEquals("Infestans", infestans.getNombre());
	}
}
