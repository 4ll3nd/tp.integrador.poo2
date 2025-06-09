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
		tipoDeOpinion = new Vinchuca(especie);
	}

	@Test
	void test_unaOpinionDeVinchucaTieneUnNombre() {
		
		when(especie.getNombre()).thenReturn("Guasayana");
		
		assertEquals("Guasayana", tipoDeOpinion.getOpinion());
	}

}
