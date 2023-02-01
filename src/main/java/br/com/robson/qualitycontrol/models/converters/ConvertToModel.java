package br.com.robson.qualitycontrol.models.converters;

@FunctionalInterface
public interface ConvertToModel<Destino> {
	
	public Destino executa(Object obj);

}