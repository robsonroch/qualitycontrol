package br.com.robson.qualitycontrol.models.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.AllocationQuality;
import br.com.robson.qualitycontrol.resources.requests.AllocationRequest;
import br.com.robson.qualitycontrol.services.EmployeeService;
import br.com.robson.qualitycontrol.services.SectorService;

@Component
public class RequestToAlocacaoQualidade implements ConvertToModel<AllocationQuality>{

	@Autowired
	private EmployeeService serviceFunc;
	
	@Autowired
	private SectorService stService;

	@Override
	public AllocationQuality executa(Object origin) {
		
		AllocationRequest request = (AllocationRequest) origin;
		 return  new AllocationQuality(serviceFunc.getEmployeeByCPF(request.getCpf()), stService.findById(request.getSectorId()));		 
	}
	
}
