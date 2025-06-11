package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstadoVerificado implements IEstadoDeMuestra {

	@Override
	public void agregarOpinion(Muestra muestra, Opinion unaOpinion) {

	}

	@Override
	//codigo repetido con EstadoNoVerificado...Posible templateMethod
	public String resultadoActual(Muestra muestra) {
		List<Opinion> opinionesExpertos = muestra.getOpiniones().stream()
		                                                        .filter(o->o.getVoto() == Voto.VotoExperto)
		                                                        .toList();
		List<String> opinionStrExperto = new ArrayList<String>();
		for(Opinion o: opinionesExpertos) {
			opinionStrExperto.add(o.getOpinion());
		}
		
		Map<String, Integer> ocurrencias = new HashMap<>();
		
		for(String s: opinionStrExperto) {
			ocurrencias.put(s, ocurrencias.getOrDefault(s, 0) + 1);
		}
		
		String masFrecuente = "";
		int maxOcurrencia = 0;
		//recorro un set con las entradas del map, para encontrar aquella que tenga
		//una mayor ocurrencia y retornar la clave de esa entrada
		for(Map.Entry<String, Integer> entrada:ocurrencias.entrySet()) {
			if(entrada.getValue() > maxOcurrencia) {
				masFrecuente = entrada.getKey();
				maxOcurrencia = entrada.getValue();
			}
		}
		return masFrecuente;
	}
}
