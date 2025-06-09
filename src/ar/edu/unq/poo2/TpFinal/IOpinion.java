package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;

public interface IOpinion {
	
	String getOpinion();
	Integer getId();
	Voto getVoto();
	LocalDate getFecha();
}
