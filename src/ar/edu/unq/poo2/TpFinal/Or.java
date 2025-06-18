package ar.edu.unq.poo2.TpFinal;

import java.util.List;
import java.util.stream.Stream;

public class Or implements Operador {

	@Override
	public List<Muestra> evaluar(List<Muestra> muestras1, List<Muestra> muestras2) {
		return Stream.concat(muestras1.stream(), muestras2.stream()).distinct().toList();
	}

}
