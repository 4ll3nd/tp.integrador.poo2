package ar.edu.unq.poo2.TpFinal;

import java.util.List;

public class Compuesto implements Filtro {

	private Operador operador;
	private Filtro filtro2;
	private Filtro filtro1;

	public Compuesto(Filtro filtro1, Filtro filtro2, Operador operador) {
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
		this.operador = operador;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {

		return this.operador.evaluar(this.filtro1.filtrar(muestrasAFiltrar), this.filtro2.filtrar(muestrasAFiltrar));
	}

}
