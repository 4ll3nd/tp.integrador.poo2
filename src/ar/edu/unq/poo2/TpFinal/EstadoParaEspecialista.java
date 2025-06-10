package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;

public class EstadoParaEspecialista extends EstadoDeCategoria {

	@Override
	public void subirCategoria(Participante unParticipante) {
		// TODO Auto-generated method stub

	}

	@Override
	public void opinar(ITipoDeOpinion tipoDeOpinion, Muestra unaMuestra, Participante unParticipante) {
		
		IOpinion unaOpinion = new Opinion(LocalDate.now(), unParticipante.getId(), Voto.VotoDeExperto, tipoDeOpinion);
		agregar(unaOpinion, unaMuestra, unParticipante);	

	}


}
