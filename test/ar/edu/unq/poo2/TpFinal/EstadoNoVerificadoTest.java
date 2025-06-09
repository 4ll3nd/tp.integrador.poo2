package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoNoVerificadoTest {
	EstadoNoVerificado noVerificado;
	Muestra muestra;
	Opinion opinion;
	@BeforeEach
	void setUp() throws Exception {
		muestra = mock(Muestra.class);
		noVerificado = new EstadoNoVerificado();
		opinion = mock(Opinion.class);
	}

	@Test
	void testSeAgregaUnaOpinionDeUnParticipanteBasico() {
		when(opinion.getVoto()).thenReturn(Voto.VotoExperto);
		noVerificado.agregarOpinion(muestra, opinion);
		
		verify(muestra).doAgregarOpinion(opinion);
	}
	
	//duda: se verifica realmente el cambio de estado.
	@Test
	void testSeAgregaUnaOpinionDeUnExpertoYLaMuestraCambiaDeEstadoAStandBy() {
		when(opinion.getVoto()).thenReturn(Voto.VotoExperto);
		noVerificado.agregarOpinion(muestra, opinion);
		
		verify(muestra).doAgregarOpinion(opinion);;
	}
	
}
