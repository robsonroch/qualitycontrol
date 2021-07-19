package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.resources.response.AllocationResponse;

@Component
public class AllocationToResponse implements ConvertFromModel<Allocation>{

	@Override
	public Object executa(Allocation model) {
		
		return AllocationResponse.builder()		
		.sectorName(model.getSector().getName())
		.employeeName(model.getEmployee().getCompleteName())
		.cpf(model.getEmployee().getCpf())
		.startAllocationDate(model.getId().getStartAllocationDate())
		.endAllocationDate(model.isActual()? null : model.getEndAllocationDate())
		.build();
		
	}

}
