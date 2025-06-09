package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParticipanteTest {
	
	private Participante participante;
	private ITipoDeOpinion tipoDeOpinion;
	private Muestra muestra;

	@BeforeEach
	void setUp() throws Exception {
		
		tipoDeOpinion = mock(ITipoDeOpinion.class);
		muestra = mock(Muestra.class);
		participante = new Participante(1);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
