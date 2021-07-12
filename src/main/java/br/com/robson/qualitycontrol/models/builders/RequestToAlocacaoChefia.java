package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.AlocacaoChefia;
import br.com.robson.qualitycontrol.models.AlocacaoQualidade;
import br.com.robson.qualitycontrol.models.Funcionario;
import br.com.robson.qualitycontrol.models.Setor;
import br.com.robson.qualitycontrol.resources.requests.AlocacaoRequest;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;

@Component
public class RequestToAlocacaoChefia implements ConvertToModel<AlocacaoChefia>{

	@Override
	public AlocacaoChefia executa(Object origin) {
		
		AlocacaoRequest request = (AlocacaoRequest) origin;
		 return  new AlocacaoChefia(Funcionario.builder().id(request.getFuncionarioId()).build(), Setor.builder().id(request.getSetorId()).build());
	}
	
}
