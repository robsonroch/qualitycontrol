package br.com.robson.qualitycontrol.models.converters;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.Observer;
import br.com.robson.qualitycontrol.resources.response.EmployeeResponse;
import br.com.robson.qualitycontrol.resources.response.ObserverResponse;

@Component
public class ObserverToResponse implements ConvertFromModel<Observer>{

	@Override
	public Object executa(Observer model) {
						
		return ObserverResponse.builder()		
		.firstName(model.getFirstName())
		.lastName(model.getLastName())
		.email(model.getEmail())
		.build();
		
	}

}
