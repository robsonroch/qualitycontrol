package br.com.robson.qualitycontrol.models.builders;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.resources.response.EmployeeResponse;

@Component
public class EmployeeToResponse implements ConvertFromModel<Employee>{

	@Override
	public Object executa(Employee model) {
		
		String firstName = model.getCompleteName().split(" ")[0];
		String[] split = model.getCompleteName().split(" ");
		String lastName = "";
		for(int i = 1; i < split.length; i++) {
			String part = split[i];
			lastName += " ".concat(part);
		}
				
		return EmployeeResponse.builder()		
		.cpf(model.getCpf())
		.firstName(firstName)
		.lastName(lastName.trim())
		.email(model.getEmail())
		.build();
		
	}

}
