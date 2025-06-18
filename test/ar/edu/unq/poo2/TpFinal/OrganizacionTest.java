package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizacionTest {
	
	private OrganizacionNoGubernamental organizacion;
	private Ubicacion ubicacion;
	private FuncionalidadExterna funcionalidadDeAgregado;
	private FuncionalidadExterna funcionalidadDeVerificacion;
	private Muestra muestra;
	private ZonaDeCobertura zona;

	@BeforeEach
	void setUp() throws Exception {

		zona = mock(ZonaDeCobertura.class);
		muestra = mock(Muestra.class);
		funcionalidadDeAgregado = mock(FuncionalidadExterna.class);
		funcionalidadDeVerificacion = mock(FuncionalidadExterna.class);
		ubicacion = mock(Ubicacion.class);
		TipoDeOrganizacion salud = TipoDeOrganizacion.Salud;
		organizacion = new OrganizacionNoGubernamental(ubicacion, salud, 500, funcionalidadDeAgregado, funcionalidadDeVerificacion);
	}

	// Test de getters

	@Test
	void getUbicacionesTest() {
		assertEquals(ubicacion, organizacion.getUbicacion());

	}

	@Test
	void getTipoDeOrganizacionTest() {
		assertEquals(TipoDeOrganizacion.Salud, organizacion.getTipoDeOrganizacion());
	}

	@Test
	void getCantidadDeEmpleadosTest() {
		assertEquals(500, organizacion.getCantidadDeEmpleados());
	}
	
	@Test
	void unaOrganizacionCambiaDeFuncionalidadParaAgregarMuestra() {
		
		FuncionalidadExterna nuevaFuncionalidad = mock(FuncionalidadExterna.class);
		
		organizacion.setFuncionalidadExternaNuevaMuestra(nuevaFuncionalidad);
		
		verifyNoInteractions(nuevaFuncionalidad);
	}
	
	@Test
	void unaOrganizacionCambiaDeFuncionalidadParaVerificarMuestra() {
		
		FuncionalidadExterna nuevaFuncionalidad = mock(FuncionalidadExterna.class);
		
		organizacion.setFuncionalidadExternaVerificacion(nuevaFuncionalidad);
		
		verifyNoInteractions(nuevaFuncionalidad);
	}
	
	@Test
	void cuandoSeAgregaUnaNuevaMuestra_LaFuncionalidadExternaDeMuestraEjecutaUnEvento() {
		
		organizacion.updateNuevaMuestra(muestra, zona);
		
		verify(funcionalidadDeAgregado).nuevoEvento(organizacion, zona, muestra);
		
	}
	
	@Test
	void cuandoSeVerificaUnaMuestra_LaFuncionalidadExternaDeVerifiacionEjecutaUnEvento() {
		
		organizacion.updateVerificacionDeMuestra(muestra, zona);
		
		verify(funcionalidadDeVerificacion).nuevoEvento(organizacion, zona, muestra);
		
	}

}
