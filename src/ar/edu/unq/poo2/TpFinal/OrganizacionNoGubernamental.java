package ar.edu.unq.poo2.TpFinal;

public class OrganizacionNoGubernamental implements IObserverOrganizacion {

	private int cantidadDeEmpleados;
	private Ubicacion ubicacion;
	private TipoDeOrganizacion tipoDeOrganizacion;
	private FuncionalidadExterna funcionalidadDeAgregado;
	private FuncionalidadExterna funcionalidadDeVerificacion;

	public OrganizacionNoGubernamental(Ubicacion ubi, TipoDeOrganizacion tipOrga, int empleados, FuncionalidadExterna funcionalidadDeAgregado, FuncionalidadExterna funcionalidadDeVerificacion) {
		this.cantidadDeEmpleados = empleados;
		this.ubicacion = ubi;
		this.tipoDeOrganizacion = tipOrga;
		this.funcionalidadDeAgregado = funcionalidadDeAgregado;
		this.funcionalidadDeVerificacion = funcionalidadDeVerificacion;
	}

	public int getCantidadDeEmpleados() {
		return cantidadDeEmpleados;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public TipoDeOrganizacion getTipoDeOrganizacion() {
		return tipoDeOrganizacion;
	}

	public void setFuncionalidadExternaNuevaMuestra(FuncionalidadExterna funcionalidad) {
		
		this.funcionalidadDeAgregado = funcionalidad;
	}

	public void setFuncionalidadExternaVerificacion(FuncionalidadExterna funcionalidad) {
		
		this.funcionalidadDeVerificacion = funcionalidad;
	}

	@Override
	public void updateNuevaMuestra(Muestra muestra, ZonaDeCobertura zona) {
		
		getFuncionalidadDeAgregado().nuevoEvento(this, zona, muestra);
	}

	private FuncionalidadExterna getFuncionalidadDeAgregado() {

		return this.funcionalidadDeAgregado;
	}

	@Override
	public void updateVerificacionDeMuestra(Muestra muestra, ZonaDeCobertura zona) {
		
		getFuncionalidadDeVerificacion().nuevoEvento(this, zona, muestra);
	}

	private FuncionalidadExterna getFuncionalidadDeVerificacion() {
		
		return this.funcionalidadDeVerificacion;
	}

}
