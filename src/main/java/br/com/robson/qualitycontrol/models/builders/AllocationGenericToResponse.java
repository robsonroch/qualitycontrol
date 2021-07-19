package br.com.robson.qualitycontrol.models.builders;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.AllocationGeneric;
import br.com.robson.qualitycontrol.resources.response.AllocationResponse;

@Component
public class AllocationGenericToResponse implements ConvertFromModel<AllocationGeneric>{

	private Date endAllocationDate = new GregorianCalendar(3000, 1 - 1, 1).getTime();
	
	@Override
	public Object executa(AllocationGeneric model) {
		
		return AllocationResponse.builder()		
		.sectorName(model.getSectorName())
		.employeeName(model.getEmployeeName())
		.typeAllocation(model.getTypeAllocation())
		.cpf(model.getCpf())
		.startAllocationDate(model.getStartAllocationDate())
		//.dataSaida(this.dataSaida.getTime() == new GregorianCalendar(3000, 1 - 1, 1).getTime().getTime() ? null : model.getDataSaida())
		.build();
		
	}

}
