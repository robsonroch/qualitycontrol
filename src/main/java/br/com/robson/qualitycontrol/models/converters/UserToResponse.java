package br.com.robson.qualitycontrol.models.converters;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.User;
import br.com.robson.qualitycontrol.resources.response.EmployeeResponse;
import br.com.robson.qualitycontrol.resources.response.ObserverResponse;

@Component
public class UserToResponse implements ConvertFromModel<User>{

	@Override
	public Object executa(User model) {
						
		return ObserverResponse.builder()		
		.firstName(model.getFirstName())
		.lastName(model.getLastName())
		.email(model.getEmail())
		.build();
		
	}

}
