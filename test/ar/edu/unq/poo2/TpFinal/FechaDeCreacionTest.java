package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FechaDeCreacionTest {
	
	private FechaDeCreacion unFiltroDeFechaDeCreacion;
	private LocalDate unaFecha;
	

	@BeforeEach
	void setUp() throws Exception {
		
		unaFecha = mock(LocalDate.class);
		unFiltroDeFechaDeCreacion = new FechaDeCreacion(unaFecha);
	}

	@Test
	void test_SiUnFiltroRecibeUnaListaVacia_DevuelveUnaListaVacia() {
				
		assertTrue(unFiltroDeFechaDeCreacion.filtrar(new ArrayList<Muestra>()).isEmpty());
	}
	
	@Test
	void test_SiTodasLasMuestraCumplenConLaFechaDeCreacion_NoSeFiltraNingunaMuestra() {
		
		LocalDate fecha = LocalDate.of(2024, 5, 2);
		
		List<Muestra> muestras = agregar(2, fecha);
		
		when(unaFecha.isEqual(fecha)).thenReturn(true);
		
		assertEquals(unFiltroDeFechaDeCreacion.filtrar(muestras).size(), muestras.size());
	}
	
	@Test
	void test_SiNingunaMuestraCumplenConLaFechaDeCreacion_SeFiltranTodas() {
		
		LocalDate fecha = LocalDate.of(2024, 5, 2);
		
		List<Muestra> muestras = agregar(5, fecha);
		
		when(unaFecha.isEqual(fecha)).thenReturn(false);
		
		assertTrue(unFiltroDeFechaDeCreacion.filtrar(muestras).isEmpty());
	}
	
	@Test
	void test_SiUnaMuestraCumpleConElCriterioDelFiltro_ElFiltroLaAgrega() {
		
		LocalDate fecha = LocalDate.of(2024, 5, 2);
		
		List<Muestra> muestras = agregar(2, fecha);
		
		Muestra nuevaMuestra = muestraConFecha(fecha);
		
		when(unaFecha.isEqual(fecha)).thenReturn(true);
		
		muestras.add(nuevaMuestra);
		
		assertTrue(unFiltroDeFechaDeCreacion.filtrar(muestras).contains(nuevaMuestra));
	}
	
	@Test
	void test_SiUnaMuestraNoCumpleConElCriterioDelFiltro_ElFiltroNoLaAgrega() {
		
		LocalDate fecha = LocalDate.of(2024, 5, 2);
		
		List<Muestra> muestras = agregar(2, fecha);
		
		Muestra nuevaMuestra = muestraConFecha(fecha);
		
		when(unaFecha.isEqual(fecha)).thenReturn(false);
		
		muestras.add(nuevaMuestra);
		
		assertFalse(unFiltroDeFechaDeCreacion.filtrar(muestras).contains(nuevaMuestra));
	}

	private List<Muestra> agregar(Integer cantidadDeMuestras, LocalDate unaFechaDeCreacion) {
		
		List<Muestra> muestras = new ArrayList<Muestra>();
		
		while(cantidadDeMuestras > 0) {
			
			muestras.add(muestraConFecha(unaFechaDeCreacion));
			cantidadDeMuestras--;
		}
		
		return muestras;
	}

	private Muestra muestraConFecha(LocalDate unaFechaDeCreacion) {
		
		Muestra muestra = mock(Muestra.class);
		when(muestra.getFechaDeSubida()).thenReturn(unaFechaDeCreacion);
		return muestra;
	}

}
