package br.com.robson.qualitycontrol.models.converters;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.enums.Perfil;
import br.com.robson.qualitycontrol.resources.response.EmployeeResponse;

@Component
public class EmployeeToResponse implements ConvertFromModel<Employee>{

	@Override
	public EmployeeResponse executa(Employee model) {
		
		Optional<Allocation> alloc = model.getAllocationOfEmployee().stream().filter(a -> a.isActual()).findAny();
		String sigla = "Sem Setor";
		Long sectorId = null;
		if(alloc.isPresent()) {
			sigla = alloc.get().getSector().getAcronym();
			sectorId = alloc.get().getSector().getId();
		}
						
		return EmployeeResponse.builder()		
		.cpf(model.getCpf())
		.firstName(model.getFirstName())
		.lastName(model.getLastName())
		.email(model.getEmail())
		.sectorId(sectorId)
		.id(model.getId())
		.build();
		
	}

}
