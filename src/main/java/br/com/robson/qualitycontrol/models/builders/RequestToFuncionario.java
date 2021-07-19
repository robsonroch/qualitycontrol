package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.resources.requests.EmployeeRequest;

@Component
public class RequestToFuncionario implements ConvertToModel<Employee>{

	@Override
	public Employee executa(Object origin) {
		
		EmployeeRequest request = (EmployeeRequest) origin;
		 Employee func = Employee.builder()
		.cpf(request.getCpf())
		.completeName(request.getFirstName().concat(" ").concat(request.getLastName()))
		.email(request.getEmail()).build();
		return func;
	}
	
}
