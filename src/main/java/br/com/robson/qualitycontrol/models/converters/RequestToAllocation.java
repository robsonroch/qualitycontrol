package br.com.robson.qualitycontrol.models.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.AllocationBoss;
import br.com.robson.qualitycontrol.resources.requests.AllocationRequest;
import br.com.robson.qualitycontrol.services.EmployeeService;
import br.com.robson.qualitycontrol.services.SectorService;

@Component
public class RequestToAllocation implements ConvertToModel<Allocation>{
	
	@Autowired
	private EmployeeService serviceFunc;
	
	@Autowired
	private SectorService stService;

	@Override
	public Allocation executa(Object origin) {
		
		AllocationRequest request = (AllocationRequest) origin;
		 return  (AllocationBoss) AllocationBoss.builder()
		 .employee(serviceFunc.getEmployeeByCPF(request.getCpf()))
		 .sector(stService.findById(request.getSectorId()))
		 .build();		 
	}
	
}
