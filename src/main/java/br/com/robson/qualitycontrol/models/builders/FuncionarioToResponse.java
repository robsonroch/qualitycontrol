package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.resources.response.FuncionarioResponse;

@Component
public class FuncionarioToResponse implements ConvertFromModel<Employee>{

	@Override
	public Object executa(Employee model) {
		
		return FuncionarioResponse.builder()		
		.cpf(model.getCpf())
		.nome(model.getNomeCompleto().split(" ")[0])
		.sobreNome(model.getNomeCompleto().split(" ")[1])
		.email(model.getEmail()).build();
		
	}

}
