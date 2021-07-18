package br.com.robson.qualitycontrol.models.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.AllocationBoss;
import br.com.robson.qualitycontrol.models.AlocacaoQualidade;
import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.resources.requests.AllocationRequest;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;
import br.com.robson.qualitycontrol.services.FuncionarioService;
import br.com.robson.qualitycontrol.services.SetorService;

@Component
public class RequestToAlocacaoChefia implements ConvertToModel<AllocationBoss>{

	@Autowired
	private FuncionarioService serviceFunc;
	
	@Autowired
	private SetorService stService;

	@Override
	public AllocationBoss executa(Object origin) {
		
		AllocationRequest request = (AllocationRequest) origin;
		Employee funcionarioByCPF = serviceFunc.getEmployeeByCPF(request.getCpf());
		 Sector findById = stService.findById(request.getSetorId());
		 return  new AllocationBoss(funcionarioByCPF, findById);
		 		 
	}
	
}
