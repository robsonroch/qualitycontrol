package br.com.robson.qualitycontrol.models.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.User;
import br.com.robson.qualitycontrol.models.enums.Perfil;
import br.com.robson.qualitycontrol.resources.requests.UserRequest;

@Component
public class RequestToUser implements ConvertToModel<User>{
	
	
	@Autowired
	private BCryptPasswordEncoder cripter;

	@Override
	public User executa(Object origin) {
		UserRequest request = (UserRequest) origin;
		
		User observer = new User();
		observer.setEmail(request.getEmail());
		observer.setFirstName(request.getFirstName());
		observer.setLastName(request.getLastName());
		observer.setPassword(cripter.encode(request.getPassword()));
		observer.setPerfis(Perfil.OBSERVER);
		observer.setId(request.getId());

		return observer;
	}
	
}
