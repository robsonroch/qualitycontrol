package br.com.robson.qualitycontrol.models.converters;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.resources.response.EmployeeResponse;

@Component
public class EmployeeToResponse implements ConvertFromModel<Employee>{

	@Override
	public Object executa(Employee model) {
						
		return EmployeeResponse.builder()		
		.cpf(model.getCpf())
		.firstName(model.getFirstName())
		.lastName(model.getLastName())
		.email(model.getEmail())
		.build();
		
	}

}
