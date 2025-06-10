package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoParaEspecialistaTest {

	private EstadoParaEspecialista estado;
	private Participante participante;
	private ITipoDeOpinion tipoDeOpinion;
	private Muestra muestra;

	@BeforeEach
	void setUp() throws Exception {
		
		muestra = mock(Muestra.class);
		tipoDeOpinion = mock(ITipoDeOpinion.class);
		participante = mock(Participante.class);
		estado = new EstadoParaEspecialista();
	}
	@Test
	void test_unEstadoParaEspecialistaAgregaUnaOpinionAlParticipante() {
		
		estado.opinar(tipoDeOpinion, muestra, participante);
		
		verify(participante).agregarOpinion(any());
	}
	
	@Test
	void test_unEstadoParaEspecialistaAgregaUnaOpinionALaMuestra() {
		
		estado.opinar(tipoDeOpinion, muestra, participante);
		
		verify(muestra).agregarOpinion(any());
	}

}
