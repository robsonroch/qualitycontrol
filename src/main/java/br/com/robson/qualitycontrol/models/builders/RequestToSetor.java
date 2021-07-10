package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Funcionario;
import br.com.robson.qualitycontrol.models.Setor;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;
import br.com.robson.qualitycontrol.resources.requests.SetorRequest;

@Component
public class RequestToSetor implements ConvertToModel<Setor>{

	@Override
	public Setor executa(Object origin) {
		
		SetorRequest sr = (SetorRequest) origin;
		
		return Setor.builder()
		.nome(sr.getNome())
		.build();
		
	}
	
}
