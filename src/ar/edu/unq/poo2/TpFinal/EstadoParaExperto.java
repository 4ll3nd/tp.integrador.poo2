package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;

public class EstadoParaExperto implements IEstadoDeCategoria {

	@Override
	public void cambiarCategoria(Participante unParticipante) {
		
		unParticipante.setEstado(new EstadoParaEspecialista());
	}

	@Override
	public void opinar(ITipoDeOpinion tipoDeOpinion, Muestra unaMuestra, Participante unParticipante) {
		
		IOpinion unaOpinion = new Opinion(LocalDate.now(), unParticipante.getId(), Voto.VotoDeExperto, tipoDeOpinion);
		unParticipante.agregarOpinion(unaOpinion);
		unaMuestra.agregarOpinion(unaOpinion);
		
	}
}
