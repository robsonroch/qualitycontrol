package br.com.robson.qualitycontrol.models.converters;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.enums.Perfil;
import br.com.robson.qualitycontrol.resources.requests.EmployeeRequest;

@Component
public class RequestToFuncionario implements ConvertToModel<Employee>{
	
	@Autowired
	private BCryptPasswordEncoder cripter;

	@Override
	public Employee executa(Object origin) {
		 EmployeeRequest request = (EmployeeRequest) origin;
		
		 Employee func = Employee.builder()
		.cpf(request.getCpf())
		.firstName(request.getFirstName())
		.lastName(request.getLastName())
		.email(request.getEmail())
		.password(cripter.encode(request.getPassword()))
		.perfis(new HashSet<>())
		.ativo(true)
		.build();
		func.setPerfis(Perfil.FUNCIONARIO);
		return func;
	}
	
}
