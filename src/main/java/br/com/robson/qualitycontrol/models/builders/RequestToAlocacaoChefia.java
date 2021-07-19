package br.com.robson.qualitycontrol.models.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.AllocationBoss;
import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.resources.requests.AllocationRequest;
import br.com.robson.qualitycontrol.services.EmployeeService;
import br.com.robson.qualitycontrol.services.SectorService;

@Component
public class RequestToAlocacaoChefia implements ConvertToModel<AllocationBoss>{

	@Autowired
	private EmployeeService serviceFunc;
	
	@Autowired
	private SectorService stService;

	@Override
	public AllocationBoss executa(Object origin) {
		
		AllocationRequest request = (AllocationRequest) origin;
		Employee funcionarioByCPF = serviceFunc.getEmployeeByCPF(request.getCpf());
		 Sector findById = stService.findById(request.getSectorId());
		 return  new AllocationBoss(funcionarioByCPF, findById);
		 		 
	}
	
}
