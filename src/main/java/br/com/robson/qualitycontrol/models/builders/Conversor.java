package br.com.robson.qualitycontrol.models.builders;

@FunctionalInterface
public interface Conversor<Origin, Destino> {
	
	public Destino executa(Origin origin);

}
