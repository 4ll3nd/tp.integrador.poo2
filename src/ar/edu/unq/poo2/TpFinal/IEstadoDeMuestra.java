package ar.edu.unq.poo2.TpFinal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class IEstadoDeMuestra {

	public abstract void agregarOpinion(Muestra muestra, IOpinion unaOpinion);
	public final String resultadoActual(Muestra muestra) {
		
		List<String> listaStrFiltrada = this.doFiltrarOpiniones(muestra);
		
		Map<String, Integer> ocurrencias = new HashMap<>();
		for(String s: listaStrFiltrada) {
			ocurrencias.put(s, ocurrencias.getOrDefault(s, 0) + 1);
		}
		
		String masFrecuente = "";
		int maxOcurrencia = 0;
		
		for(Map.Entry<String, Integer> entrada:ocurrencias.entrySet()) {
			if(entrada.getValue() > maxOcurrencia) {
				masFrecuente = entrada.getKey();
				maxOcurrencia = entrada.getValue();
			}
		}
		return masFrecuente;
	}
	protected abstract List<String> doFiltrarOpiniones(Muestra muestra);
	
	public abstract boolean estaEn(String estadoPosible);
}
