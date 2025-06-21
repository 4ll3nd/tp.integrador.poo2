package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class EstadoNoVerificado extends IEstadoDeMuestra {

	@Override
	public void agregarOpinion(Muestra muestra, IOpinion unaOpinion) {
		if(unaOpinion.tieneVoto(Voto.VotoDeExperto)) {
			muestra.setEstado(new EstadoStandBy());
			muestra.doAgregarOpinion(unaOpinion);
		}
		else {
			muestra.doAgregarOpinion(unaOpinion);
		}
	}

	@Override
	public boolean estaEn(String estadoPosible) {
		return estadoPosible.equalsIgnoreCase("No Verificado");
	}
	
	@Override
	protected List<String> doFiltrarOpiniones(Muestra muestra) {
		List<String> opinionStr = new ArrayList<String>();
		for(IOpinion o: muestra.getOpiniones()) {
			opinionStr.add(o.getOpinion());
		}
		opinionStr.add(muestra.getEspecie().getNombre());
		return opinionStr;
	}
}
