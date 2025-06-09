package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VinchucaTest {
	
	EspecieDeVinchuca especie;
	ITipoDeOpinion tipoDeOpinion;

	@BeforeEach
	void setUp() throws Exception {
		
		especie = mock(EspecieDeVinchuca.class);
		tipoDeOpinion = new ChinceFoliada();
	}

	@Test
	void test_unaOpinionTieneUnNombre() {
		
		assertEquals("Chinche Foliada", tipoDeOpinion.getOpinion());
	}

}
