package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstadoVerificado extends IEstadoDeMuestra {

	@Override
	public void agregarOpinion(Muestra muestra, IOpinion unaOpinion) {

	}

	@Override
	public boolean estaEn(String estadoPosible) {
		return estadoPosible.equalsIgnoreCase("Verificado");
	}

	@Override
	protected List<String> doFiltrarOpiniones(Muestra muestra) {
		List<IOpinion> opinionesExpertos = muestra.getOpiniones().stream()
                .filter(o->o.tieneVoto(Voto.VotoDeExperto))
                .toList();
		
		List<String> opinionStrExperto = new ArrayList<String>();
		for(IOpinion o: opinionesExpertos) {
			opinionStrExperto.add(o.getOpinion());
		};
		return opinionStrExperto;
	}
}
