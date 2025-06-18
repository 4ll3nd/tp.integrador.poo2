package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;
import java.util.List;

public class UltimaVotacion implements Filtro {
	private LocalDate fechaDeOpinion;
	public UltimaVotacion(LocalDate fechaDeOpinion) {
		this.fechaDeOpinion = fechaDeOpinion;
	}
	public LocalDate getFechaDeOpinion() {
		return fechaDeOpinion;
	}
	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream()
				.filter(m -> tieneOpinionesEnLaMismaFecha(m, this.getFechaDeOpinion())).
				toList();
	}
	private boolean tieneOpinionesEnLaMismaFecha(Muestra muestra, LocalDate fechaDeOpinion) {
		return muestra.getOpiniones().stream().anyMatch(o->o.getFecha().isEqual(fechaDeOpinion));
	}
}
