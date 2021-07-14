package br.com.robson.qualitycontrol.models.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.AlocacaoChefia;
import br.com.robson.qualitycontrol.models.AlocacaoQualidade;
import br.com.robson.qualitycontrol.models.Funcionario;
import br.com.robson.qualitycontrol.models.Setor;
import br.com.robson.qualitycontrol.resources.requests.AlocacaoRequest;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;
import br.com.robson.qualitycontrol.services.FuncionarioService;
import br.com.robson.qualitycontrol.services.SetorService;

@Component
public class RequestToAlocacaoChefia implements ConvertToModel<AlocacaoChefia>{

	@Autowired
	private FuncionarioService serviceFunc;
	
	@Autowired
	private SetorService stService;

	@Override
	public AlocacaoChefia executa(Object origin) {
		
		AlocacaoRequest request = (AlocacaoRequest) origin;
		Funcionario funcionarioByCPF = serviceFunc.getFuncionarioByCPF(request.getCpf());
		 Setor findById = stService.findById(request.getSetorId());
		 return  new AlocacaoChefia(funcionarioByCPF, findById);
		 		 
	}
	
}
