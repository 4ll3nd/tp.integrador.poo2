package ar.edu.unq.poo2.TpFinal;

import java.util.List;

public class And implements Operador {

	@Override
	public List<Muestra> evaluar(List<Muestra> muestras1, List<Muestra> muestras2) {
		return muestras1.stream().filter(m -> muestras2.contains(m)).toList();
	}

}
