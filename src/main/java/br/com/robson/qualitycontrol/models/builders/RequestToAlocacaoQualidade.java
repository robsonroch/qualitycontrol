package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.AlocacaoQualidade;
import br.com.robson.qualitycontrol.models.Funcionario;
import br.com.robson.qualitycontrol.models.Setor;
import br.com.robson.qualitycontrol.resources.requests.AlocacaoRequest;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;

@Component
public class RequestToAlocacaoQualidade implements ConvertToModel<AlocacaoQualidade>{

	@Override
	public AlocacaoQualidade executa(Object origin) {
		
		AlocacaoRequest request = (AlocacaoRequest) origin;
		 return new AlocacaoQualidade(Funcionario.builder().id(request.getFuncionarioId()).build(), Setor.builder().id(request.getSetorId()).build());
		 		 
	}
	
}
