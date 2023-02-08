package br.com.robson.qualitycontrol.models.converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.resources.response.AllocationEmployeeResponse;
import br.com.robson.qualitycontrol.resources.response.AllocationResponse;

@Component
public class AllocationToAllocationEmployeeResponse implements ConvertFromModel<Allocation>{

	@Override
	public AllocationEmployeeResponse executa(Allocation model) {
		
		return AllocationEmployeeResponse.builder()		
		.setor(model.getSector().getAcronym())
		.firstName(model.getEmployee().getFirstName())
		.lastName(model.getEmployee().getLastName())
		.cpf(model.getEmployee().getCpf())
		.email(model.getEmployee().getEmail())
		.id(model.getEmployee().getId())
		.perfis(model.getEmployee().getPerfis().stream().map(p -> p.getDescricao()).collect(Collectors.toList()))
		.build();
		
	}

}
