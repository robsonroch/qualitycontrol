package br.com.robson.qualitycontrol.models.builders;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
	
	public Target convertoFrom(Object obj) {
		Constructor<Target> ctor;
		try {
			ctor = elementType.getConstructor(obj.getClass());
			return (ctor.newInstance(obj));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //c.getConstructor(type);
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
