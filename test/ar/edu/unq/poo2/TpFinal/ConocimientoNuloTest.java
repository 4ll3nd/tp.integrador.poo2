package ar.edu.unq.poo2.TpFinal;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConocimientoNuloTest {
	
	private ConocimientoNulo conocimientoNulo;
	private Participante participante;

	@BeforeEach
	void setUp() throws Exception {
		
		conocimientoNulo = new ConocimientoNulo("Sin conocimientos");
		participante     = mock(Participante.class);
	}

	@Test
	void test_elConocimientoNuloIndicaQueElParticipanteComienzaComoBasico() {
		
		conocimientoNulo.validarA(participante);
		
		verify(participante).comenzarDeCero();
	}

}
