package br.com.robson.qualitycontrol.models.converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.enums.Perfil;
import br.com.robson.qualitycontrol.resources.response.EmployeeResponse;

@Component
public class EmployeeToResponse implements ConvertFromModel<Employee>{

	@Override
	public Object executa(Employee model) {
		
		String descricao = Perfil.toEnum(1).getDescricao();
						
		return EmployeeResponse.builder()		
		.cpf(model.getCpf())
		.firstName(model.getFirstName())
		.lastName(model.getLastName())
		.email(model.getEmail())
		.perfis(model.getPerfis().stream().map(code -> code.getDescricao()).collect(Collectors.toList()))
		.build();
		
	}

}
