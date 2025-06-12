package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChincheFoliadaTest {

	ITipoDeOpinion tipoDeOpinion;

	@BeforeEach
	void setUp() throws Exception {
		
		tipoDeOpinion = new ChinceFoliada();
	}

	@Test
	void test_unaOpinionTieneUnNombre() {
		
		assertEquals("Chinche Foliada", tipoDeOpinion.getOpinion());
	}

}
