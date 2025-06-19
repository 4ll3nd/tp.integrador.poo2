package ar.edu.unq.poo2.TpFinal;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoParaBasicoTest {
	
	private EstadoParaBasico estado;
	private Participante participante;
	private ITipoDeOpinion tipoDeOpinion;
	private Muestra muestra;

	@BeforeEach
	void setUp() throws Exception {
		
		muestra = mock(Muestra.class);
		tipoDeOpinion = mock(ITipoDeOpinion.class);
		participante = mock(Participante.class);
		estado = new EstadoParaBasico();
	}
	
	@Test
	void test_unEstadoParaBasicoSubeDeCategoria() {

		estado.subirCategoria(participante);
		
		verify(participante).setEstado(any());
	}
	
	@Test
	void test_unEstadoParaBasicoNoBajaDeCategoria() {

		estado.bajarCategoria(participante);
		
		verifyNoInteractions(participante);
	}

	@Test
	void test_unEstadoParaBasicoGeneraUnaOpinion() {
		
		estado.opinar(tipoDeOpinion, muestra, participante);
	
		verify(participante).agregarOpinion(any());
	}
	
	@Test
	void test_unEstadoParaBasicoLeEnviaLaOpinionALaMuestra() {
		
		estado.opinar(tipoDeOpinion, muestra, participante);
		
		verify(muestra).agregarOpinion(any());
	}
	
	@Test
	void test_cuandoUnParticipanteEsPromocionable_SubeDeCategoria() {
		
		when(participante.esPromocionable()).thenReturn(true);
		
		estado.cambiarCategoria(participante);
		
		verify(participante).setEstado(any());
	}

}
