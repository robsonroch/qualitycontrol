package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.Observer;
import br.com.robson.qualitycontrol.resources.requests.EmployeeRequest;
import br.com.robson.qualitycontrol.resources.requests.ObserverRequest;

@Component
public class RequestToObserver implements ConvertToModel<Observer>{

	@Override
	public Observer executa(Object origin) {
		ObserverRequest request = (ObserverRequest) origin;
		
		 Employee func = Employee.builder()
		.cpf(request.getCpf())
		.firstName(request.getFirstName())
		.lastName(request.getLastName())
		.email(request.getEmail()).build();
		return func;
	}
	
}
