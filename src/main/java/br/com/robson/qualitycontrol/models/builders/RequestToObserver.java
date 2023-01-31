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
		
		Observer observer = new Observer();
		observer.setEmail(request.getEmail());
		observer.setFirstName(request.getFirstName());
		observer.setLastName(request.getLastName());
		observer.setId(request.getId());

		return observer;
	}
	
}
