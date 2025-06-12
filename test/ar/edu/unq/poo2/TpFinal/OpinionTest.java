package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpinionTest {
	
	private Opinion opinion;
	private ITipoDeOpinion tipoDeOpinion;
	private LocalDate fecha;

	@BeforeEach
	void setUp() throws Exception {
		
		tipoDeOpinion = mock(ITipoDeOpinion.class);
		fecha = LocalDate.of(1, 1, 3);
		opinion = new Opinion(fecha, 1, Voto.VotoDeBasico, tipoDeOpinion);
	}

	@Test
	void test_unaOpinionTieneUnTipoDeOpinion() {
		
		when(tipoDeOpinion.getOpinion()).thenReturn("Vinchuca");
		
		assertEquals("Vinchuca", opinion.getOpinion());
	}
	
	@Test
	void test_unaOpinionTieneUnId() {
				
		assertEquals(1, opinion.getId());
	}
	
	@Test
	void test_unaOpinionTieneUnVoto() {
				
		assertEquals(Voto.VotoDeBasico, opinion.getVoto());
	}
	
	@Test
	void test_unaOpinionTieneUnaFecha() {
				
		assertEquals(fecha, opinion.getFecha());
	}

}
