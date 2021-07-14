package br.com.robson.qualitycontrol.models.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.AlocacaoFuncionario;
import br.com.robson.qualitycontrol.models.AlocacaoQualidade;
import br.com.robson.qualitycontrol.models.Funcionario;
import br.com.robson.qualitycontrol.models.Setor;
import br.com.robson.qualitycontrol.resources.requests.AlocacaoRequest;
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
		
		AlocacaoRequest request = (AlocacaoRequest) origin;
		 return  new AlocacaoQualidade(serviceFunc.getFuncionarioByCPF(request.getCpf()), stService.findById(request.getSetorId()));		 
	}
	
}