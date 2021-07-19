package br.com.robson.qualitycontrol.models.builders;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.resources.response.EmployeeResponse;

@Component
public class EmployeeToResponse implements ConvertFromModel<Employee>{

	@Override
	public Object executa(Employee model) {
		
		String firstName = model.getCompleteName().split(" ")[0];
		String lastName = String.join(" ", Arrays.asList(model.getCompleteName().split(" ")).remove(0));
		
		return EmployeeResponse.builder()		
		.cpf(model.getCpf())
		.firstName(firstName)
		.lastName(lastName)
		.email(model.getEmail())
		.build();
		
	}

}
