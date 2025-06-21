package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.List;

public class EstadoStandBy extends IEstadoDeMuestra{
	
	public void agregarOpinion(Muestra muestra, IOpinion unaOpinion) {
		
	  if(this.existeMismaOpinion(muestra, unaOpinion) && unaOpinion.tieneVoto(Voto.VotoDeExperto)) {
		  
			muestra.setEstado(new EstadoVerificado());
			this.notificarCambioDeEstadoAZonasDeCobertura(muestra);
			muestra.doAgregarOpinion(unaOpinion);
		}
		else {
			if(unaOpinion.getVoto() == Voto.VotoDeExperto) {
				muestra.doAgregarOpinion(unaOpinion);
			}
		}
	}
	
	/**
	 * 	public void agregarOpinion(Muestra muestra, Opinion unaOpinion) {
		if(unaOpinion.getVoto() == Voto.VotoExperto) {
			this.cambiarEstadoSi(muestra, this.existeMismaOpinion(muestra, unaOpinion));
			muestra.doAgregarOpinion(unaOpinion);
			
		}
	}

	private void cambiarEstadoSi(Muestra muestra, boolean existeMismaOpinion) {
		if(existeMismaOpinion) {
			muestra.setEstado(new EstadoVerificado());
		}
	}
	 * **/
	private boolean existeMismaOpinion(Muestra muestra, IOpinion unaOpinion) {
		return muestra.getOpiniones().stream().
				anyMatch(o -> o.getOpinion().equalsIgnoreCase(unaOpinion.getOpinion()));
	}
	
	public void notificarCambioDeEstadoAZonasDeCobertura(Muestra muestra) {
		muestra.getObserverVerificacion().stream().forEach(m -> m.updateMuestraVerificada(muestra));
	}
	
	@Override
	public boolean estaEn(String estadoPosible) {
		return estadoPosible.equalsIgnoreCase("StandBy");
	}
	//aclaracion: no se agrega la especie, porque en el standby siempre hay minimo 1 experto, entonces 
	//se le tiene mas importancia a ese tipo de opinion que la especie.
	@Override
	protected List<String> doFiltrarOpiniones(Muestra muestra) {
		List<String> opinionStr = new ArrayList<String>();
		for(IOpinion o: muestra.getOpiniones().stream()
				.filter(o->o.tieneVoto(Voto.VotoDeExperto)).toList()) {
			opinionStr.add(o.getOpinion());
		}
		return opinionStr;
	}
}
