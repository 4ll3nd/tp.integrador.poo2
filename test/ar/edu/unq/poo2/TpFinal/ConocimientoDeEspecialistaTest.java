package ar.edu.unq.poo2.TpFinal;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConocimientoDeEspecialistaTest {

	private ConocimientoDeEspecialista conocimientoNulo;
	private Participante participante;

	@BeforeEach
	void setUp() throws Exception {
		
		conocimientoNulo = new ConocimientoDeEspecialista("Detección de vinchucas");
		participante     = mock(Participante.class);
	}

	@Test
	void test_elConocimientoDeEspecialistaIndicaQueElParticipanteEsEspecialista() {
		
		conocimientoNulo.validarA(participante);
		
		verify(participante).validarConocimiento();
	}

}
