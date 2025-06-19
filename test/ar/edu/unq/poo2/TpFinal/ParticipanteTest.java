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
		participante = new Participante(1, false);
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
	void test_unParticipanteNoPromocionableSoloCumpleConMasDe10EnviosDeMuestas() throws Exception  {
		
		when(muestra.getFechaDeSubida()).thenReturn(LocalDate.now().minusDays(15));
		
		agregarCantidadDeMuestras(participante, muestra, 11);

		assertFalse(participante.esPromocionable());
		
		verify(muestra, times(11)).getFechaDeSubida();
	}


	@Test
	void test_unParticipanteNoPromocionableSoloCumpleConMasDe2opiniones() throws Exception  {
		
		when(opinion.getFecha()).thenReturn(LocalDate.now().minusDays(15));
		when(muestra.getFechaDeSubida()).thenReturn(LocalDate.now().minusDays(15));
		
		agregarCantidadDeOpiniones(participante, opinion, 2);
		agregarCantidadDeMuestras(participante, muestra, 11);
		
		assertFalse(participante.esPromocionable());
		
		verify(opinion, times(2)).getFecha();
	}
	
	
	@Test
	void test_noEsPromocionableSiLasMuestrasFueronEnviadasHaceMasDe30Dias() throws Exception  {
		
		when(muestra.getFechaDeSubida()).thenReturn(LocalDate.now().minusDays(36));
		when(opinion.getFecha()).thenReturn(LocalDate.now().minusDays(15));
		
		agregarCantidadDeOpiniones(participante, opinion, 22);
		agregarCantidadDeMuestras(participante, muestra, 11);

		assertFalse(participante.esPromocionable());
		
		verify(muestra, times(11)).getFechaDeSubida();
	}
	
	@Test
	void test_noEsPromocionableSiLasOpinionesFueronHaceMasDe30Dias() throws Exception  {
		
		when(muestra.getFechaDeSubida()).thenReturn(LocalDate.now().minusDays(15));
		when(opinion.getFecha()).thenReturn(LocalDate.now().minusDays(36));
		
		agregarCantidadDeOpiniones(participante, opinion, 22);
		agregarCantidadDeMuestras(participante, muestra, 11);

		assertFalse(participante.esPromocionable());
		
		verify(opinion, times(22)).getFecha();
		verify(muestra, times(11)).getFechaDeSubida();
	}
	
	@Test
	void test_cumpleSiEnLosUltimos30DiasEnvioMasDe20OpinionesyMasDe10Muestras() throws Exception  {
		
		when(muestra.getFechaDeSubida()).thenReturn(LocalDate.now().minusDays(15));
		when(opinion.getFecha()).thenReturn(LocalDate.now().minusDays(15));
		
		agregarCantidadDeOpiniones(participante, opinion, 22);
		agregarCantidadDeMuestras(participante, muestra, 11);

		assertTrue(participante.esPromocionable());
		
		verify(opinion, times(22)).getFecha();
		verify(muestra, times(11)).getFechaDeSubida();
	}

	@Test
	void test_unParticipanteNoCambiaDeCategoriaSiNoEsPromocionable()  {
		
		participante.cambiarCategoria();
		
		assertFalse(participante.esPromocionable());
	}
	
	@Test
	void test_unParticipanteCambiaDeCategoriaSiEsPromocionable() throws Exception  {
		
		when(muestra.getFechaDeSubida()).thenReturn(LocalDate.now().minusDays(15));
		when(opinion.getFecha()).thenReturn(LocalDate.now().minusDays(15));
		
		agregarCantidadDeOpiniones(participante, opinion, 22);
		agregarCantidadDeMuestras(participante, muestra, 11);
		
		participante.cambiarCategoria();
		
		assertTrue(participante.esPromocionable());
	}
	
	@Test
	void test_unParticipanteConConocimientoValidadoPuedeAgregarOpiniones() throws Exception  {
		
		Participante especialista = new Participante(1, true);
		
		especialista.opinar(tipoDeOpinion, muestra);
		
		verify(muestra).agregarOpinion(any());
	}
	
	private void agregarCantidadDeMuestras(Participante participante, Muestra unaMuestra, Integer cantidad) {
		
		while(cantidad > 0) {
			
			participante.agregarMuestra(unaMuestra);
			cantidad--;
		}
	}
	
	private void agregarCantidadDeOpiniones(Participante participante, IOpinion opinion, int cantidad) {
		
		while(cantidad > 0) {
			
			participante.agregarOpinion(opinion);
			cantidad--;
		}
	}
}
