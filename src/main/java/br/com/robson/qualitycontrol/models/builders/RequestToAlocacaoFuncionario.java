package br.com.robson.qualitycontrol.models.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.AllocationEmployee;
import br.com.robson.qualitycontrol.resources.requests.AllocationRequest;
import br.com.robson.qualitycontrol.services.EmployeeService;
import br.com.robson.qualitycontrol.services.SectorService;

@Component
public class RequestToAlocacaoFuncionario implements ConvertToModel<AllocationEmployee>{

	@Autowired
	private EmployeeService serviceFunc;
	
	@Autowired
	private SectorService stService;

	@Override
	public AllocationEmployee executa(Object origin) {
		
		AllocationRequest request = (AllocationRequest) origin;
		 return  new  AllocationEmployee(serviceFunc.getEmployeeByCPF(request.getCpf()), stService.findById(request.getSectorId()));		 
	}
	
}
