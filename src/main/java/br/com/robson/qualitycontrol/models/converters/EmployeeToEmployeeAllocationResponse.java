package br.com.robson.qualitycontrol.models.converters;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.resources.response.EmployeeAllocationResponse;

@Component
public class EmployeeToEmployeeAllocationResponse implements ConvertFromModel<Employee>{

	@Override
	public EmployeeAllocationResponse executa(Employee model) {
		
		Optional<Allocation> alloc = model.getAllocationOfEmployee().stream().filter(a -> a.isActual()).findAny();
		String sigla = "Sem Setor";
		if(alloc.isPresent()) {
			sigla = alloc.get().getSector().getAcronym();
		}
						
		return EmployeeAllocationResponse.builder()		
		.cpf(model.getCpf())
		.firstName(model.getFirstName())
		.lastName(model.getLastName())
		.email(model.getEmail())
		.perfis(model.getPerfis().stream().map(code -> code.getDescricao()).collect(Collectors.toList()))
		.setor(sigla)
		.id(model.getId())
		.build();
		
	}

}
