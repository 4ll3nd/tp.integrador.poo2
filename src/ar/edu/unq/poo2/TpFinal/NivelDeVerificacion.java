package ar.edu.unq.poo2.TpFinal;

import java.util.List;

public class NivelDeVerificacion implements Filtro {
	private String nivelDeVerificacion;
	public NivelDeVerificacion(String nivelDeVerificacion) {
		this.nivelDeVerificacion = nivelDeVerificacion;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream().filter(m -> m.estaEn(nivelDeVerificacion)).toList();
	}

	public String getNivelDeVerificacion() {
		return nivelDeVerificacion;
	}

}
