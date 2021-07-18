package br.com.robson.qualitycontrol.models.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.AlocacaoFuncionario;
import br.com.robson.qualitycontrol.models.AlocacaoQualidade;
import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.resources.requests.AllocationRequest;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;
import br.com.robson.qualitycontrol.services.FuncionarioService;
import br.com.robson.qualitycontrol.services.SetorService;

@Component
public class RequestToAlocacaoQualidade implements ConvertToModel<AlocacaoQualidade>{

	@Autowired
	private FuncionarioService serviceFunc;
	
	@Autowired
	private SetorService stService;

	@Override
	public AlocacaoQualidade executa(Object origin) {
		
		AllocationRequest request = (AllocationRequest) origin;
		 return  new AlocacaoQualidade(serviceFunc.getEmployeeByCPF(request.getCpf()), stService.findById(request.getSetorId()));		 
	}
	
}
