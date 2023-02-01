package br.com.robson.qualitycontrol.models.converters;

@FunctionalInterface
public interface ConvertFromModel<Origin> {
	
	public Object executa(Origin origin);

}
