package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;

@Component
public class RequestToFuncionario implements ConvertToModel<Employee>{

	@Override
	public Employee executa(Object origin) {
		
		FuncionarioRequest request = (FuncionarioRequest) origin;
		 Employee func = Employee.builder()
		.cpf(request.getCpf())
		.nomeCompleto(request.getNome().concat(" ").concat(request.getSobreNome()))
		.email(request.getEmail()).build();
		return func;
	}
	
}
