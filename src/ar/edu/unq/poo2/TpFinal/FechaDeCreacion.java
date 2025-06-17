package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;
import java.util.List;

public class FechaDeCreacion implements Filtro {

	private LocalDate fecha;

	public FechaDeCreacion(LocalDate unaFecha) {
		
		setFecha(unaFecha);
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		
		return muestras.stream().filter(unaMuestra -> getFecha().isEqual(unaMuestra.getFechaDeSubida())).toList();
	}
	
	private void setFecha(LocalDate unaFecha) {
		
		this.fecha = unaFecha;
	}
	
	private LocalDate getFecha() {
		return this.fecha;
	}

}
