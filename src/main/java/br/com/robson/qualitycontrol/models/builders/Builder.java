package br.com.robson.qualitycontrol.models.builders;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Date;

import br.com.robson.qualitycontrol.models.Funcionario;

public class Builder<Target> {

	private Class<Target> elementType;
	
	private Object target;
	

	public Builder() {
		elementType = (Class<Target>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];	
	}

}
