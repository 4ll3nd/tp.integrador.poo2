package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParticipanteTest {
	
	private Participante participante;
	private ITipoDeOpinion tipoDeOpinion;
	private Muestra muestra;
	private IOpinion opinion;

	@BeforeEach
	void setUp() throws Exception {
		
		opinion = mock(IOpinion.class);
		tipoDeOpinion = mock(ITipoDeOpinion.class);
		muestra = mock(Muestra.class);
		participante = new Participante(1);
	}

	@Test
	void test_unParticipanteAgregaUnaMuestra() {
		
		participante.agregarMuestra(muestra);
		
		verifyNoInteractions(muestra);
	}
	
	@Test
	void test_unParticipanteAgregaUnaOpinion() {
				
		participante.agregarOpinion(opinion);
		
		verifyNoInteractions(opinion);
	}
	
	@Test
	void test_cuandoUnParticipanteOpinaUnaMuestra_LaMuestraRecibeSuOpinion() throws Exception {
				
		participante.opinar(tipoDeOpinion, muestra);
		
		verify(muestra).agregarOpinion(any());
	}
	
	@Test
	void test_unParticipanteNoPuedeOpinarSobreSuPropiaMuestra() {
		
		participante.agregarMuestra(muestra);
	
		assertThrows(Exception.class, () -> participante.opinar(tipoDeOpinion, muestra));
	}
	
	@Test
	void test_unParticipanteNoPuedeOpinarSobreUnaMuestraQueYaOpino() throws Exception {
		
		participante.opinar(tipoDeOpinion, muestra);
		
		when(muestra.tieneOpinionDe(participante)).thenReturn(true);
	
		assertThrows(Exception.class, () -> participante.opinar(tipoDeOpinion, muestra));
	}
	
	
	@Test
	void test_unParticipanteSabeSiCumpleLaReglaDePromocion()  {
		
		assertFalse(participante.esPromocionable());
	}
	
	@Test
	void test_unParticipanteCambiaDeCategoria()  {
		
		participante.cambiarCategoria();
		
		assertFalse(participante.esPromocionable());
	}
}
