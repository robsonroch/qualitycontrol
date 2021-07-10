package br.com.robson.qualitycontrol.models.builders;

@FunctionalInterface
public interface ConvertToModel<Destino> {
	
	public Destino executa(Object obj);

}
