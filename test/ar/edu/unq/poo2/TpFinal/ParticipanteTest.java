package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

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
	void test_unParticipanteInicialmenteNoCumpleLaReglaDePromocion()  {
		
		assertFalse(participante.esPromocionable());
	}
	
	@Test
	void test_unParticipanteNoPromocionableSoloCumpleConMasDe10Muestas() throws Exception  {
		
		when(muestra.getFecha()).thenReturn(LocalDate.of(1, 2, 3));
		
		agregarCantidadDeMuestras(participante, muestra, 11);

		assertFalse(participante.esPromocionable());
	}
	
	@Test
	void test_unParticipanteNoPromocionableSoloCumpleConMasDe20Opiniones() throws Exception  {
		
		when(muestra.getFecha()).thenReturn(LocalDate.of(2025, 6, 5));
		
		agregarCantidadDeOpiniones(participante, tipoDeOpinion, 2);
		
		assertFalse(participante.esPromocionable());
	}
	
	@Test
	void test_esPromocionableSiCumpleConMasDe20OpinionesyMasDe10Muestras() throws Exception  {
		
		when(muestra.getFecha()).thenReturn(LocalDate.of(2025, 6, 5));
		
		agregarCantidadDeMuestras(participante, muestra, 11);
		agregarCantidadDeOpiniones(participante, tipoDeOpinion, 21);
		
		assertTrue(participante.esPromocionable());
	}

	@Test
	void test_unParticipanteCambiaDeCategoria()  {
		
		participante.cambiarCategoria();
		
		assertTrue(participante.esPromocionable());
	}
	
	private void agregarCantidadDeMuestras(Participante participante, Muestra unaMuestra, int cantidad) {
		
		while(cantidad > 0) {
			
			participante.agregarMuestra(unaMuestra);
			cantidad--;
		}
	}
	
	private void agregarCantidadDeOpiniones(Participante participante, ITipoDeOpinion tipoDeOpinion, int cantidad) throws Exception {
		
		while(cantidad > 0) {
			
			participante.opinar(tipoDeOpinion, mock(Muestra.class));
			cantidad--;
		}
		
	}
}
