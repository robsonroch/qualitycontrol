package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Setor;
import br.com.robson.qualitycontrol.resources.response.SetorResponse;

@Component
public class AlocacaoToResponse implements ConvertFromModel<Setor>{

	@Override
	public Object executa(Setor model) {
		
		return SetorResponse.builder()		
		.nome(model.getNome())
		.id(model.getId())
		.build();
		
	}

}
