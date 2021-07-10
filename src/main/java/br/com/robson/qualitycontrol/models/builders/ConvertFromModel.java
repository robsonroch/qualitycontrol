package br.com.robson.qualitycontrol.models.builders;

@FunctionalInterface
public interface ConvertFromModel<Origin> {
	
	public Object executa(Origin origin);

}
