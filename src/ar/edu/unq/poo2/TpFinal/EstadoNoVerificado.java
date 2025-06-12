package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class EstadoNoVerificado implements IEstadoDeMuestra {

	@Override
	public void agregarOpinion(Muestra muestra, Opinion unaOpinion) {
		if(unaOpinion.getVoto() == Voto.VotoExperto) {
			muestra.setEstado(new EstadoStandBy());
			muestra.doAgregarOpinion(unaOpinion);
		}
		else {
			muestra.doAgregarOpinion(unaOpinion);
		}
	}
	/**PROPOSITO: obtener el resultado actual de la muestra dada
	 * */
	public String resultadoActual(Muestra muestra) {
		//en base a la lista de opiniones de la muestra obtengo una lista de String
		List<String> opinionStr = new ArrayList<String>();
		for(Opinion o: muestra.getOpiniones()) {
			opinionStr.add(o.getOpinion());
		}
		opinionStr.add(muestra.getEspecie().getNombre());
		
		//inicializo un map para guardar asociaciones Key<String> value<Integer>
		//donde la key es el string y su value es la ocurrencia de ese string en la lista
		Map<String, Integer> ocurrencias = new HashMap<>();
		
		for(String s: opinionStr) {
			ocurrencias.put(s, ocurrencias.getOrDefault(s, 0) + 1);
		}
		/*getOrDefault:
		 * “Buscá cuántas veces apareció s. Si nunca apareció, 
		 * considerá que apareció 0 veces. Después sumale 1 porque acaba de aparecer una vez más.”
		 * */

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
