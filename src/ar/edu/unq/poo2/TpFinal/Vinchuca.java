package ar.edu.unq.poo2.TpFinal;

public class Vinchuca implements ITipoDeOpinion {
	
	private EspecieDeVinchuca especie;

	public Vinchuca(EspecieDeVinchuca especie) {
		
		setEspecie(especie);
	}

	private void setEspecie(EspecieDeVinchuca especie) {
		
		this.especie = especie;
	}

	@Override
	public String getOpinion() {
		
		return getEspecie().getNombre();
	}

	private EspecieDeVinchuca getEspecie() {
		
		return this.especie;
	}

}
