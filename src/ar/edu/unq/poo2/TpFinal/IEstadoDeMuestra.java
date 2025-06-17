package ar.edu.unq.poo2.TpFinal;

public interface IEstadoDeMuestra {

	void agregarOpinion(Muestra muestra, IOpinion unaOpinion);
	public String resultadoActual(Muestra muestra);
	boolean estaEn(String estadoPosible);
}
