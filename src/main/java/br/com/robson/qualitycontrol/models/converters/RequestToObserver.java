package br.com.robson.qualitycontrol.models.converters;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.User;
import br.com.robson.qualitycontrol.resources.requests.EmployeeRequest;
import br.com.robson.qualitycontrol.resources.requests.UserRequest;

@Component
public class RequestToObserver implements ConvertToModel<User>{

	@Override
	public User executa(Object origin) {
		UserRequest request = (UserRequest) origin;
		
		User observer = new User();
		observer.setEmail(request.getEmail());
		observer.setFirstName(request.getFirstName());
		observer.setLastName(request.getLastName());
		observer.setId(request.getId());

		return observer;
	}
	
}
