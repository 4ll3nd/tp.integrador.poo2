package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UltimaVotacionTest {
	LocalDate fechaDeVotacion;
	List<Muestra> muestras;
	Opinion opinion1;
	Opinion opinion2;
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;
	UltimaVotacion ultimaVotacionBusqueda;
	@BeforeEach
	void setUp() throws Exception {
		fechaDeVotacion = LocalDate.of(2022, 3, 5);
		opinion1 = mock(Opinion.class);
		when(opinion1.getFecha()).thenReturn(fechaDeVotacion);
		opinion2 = mock(Opinion.class);
		when(opinion2.getFecha()).thenReturn(LocalDate.of(2023, 4, 5));
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
		muestras = new ArrayList<Muestra>();
		muestras = Arrays.asList(muestra1, muestra2, muestra3, muestra4);
		ultimaVotacionBusqueda = new UltimaVotacion(fechaDeVotacion);
	}

	@Test
	void testSeRecibeListaDeMuestraYSeObtieneLasMuestrasConLaFechaDada() {
		when(muestra1.getOpiniones()).thenReturn(Arrays.asList(opinion2,opinion1));
		when(muestra2.getOpiniones()).thenReturn(Arrays.asList(opinion2,opinion1));
		when(muestra3.getOpiniones()).thenReturn(Arrays.asList(opinion2));
		when(muestra4.getOpiniones()).thenReturn(Arrays.asList(opinion2));
		
		assertEquals(2, ultimaVotacionBusqueda.filtrar(muestras).size());
		assertEquals(muestra1, ultimaVotacionBusqueda.filtrar(muestras).getFirst());
		assertEquals(muestra2, ultimaVotacionBusqueda.filtrar(muestras).getLast());
		assertNotEquals(muestra3, ultimaVotacionBusqueda.filtrar(muestras).getLast());
		assertNotEquals(muestra4, ultimaVotacionBusqueda.filtrar(muestras).getFirst());
	}
	
}
