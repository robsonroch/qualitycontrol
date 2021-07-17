package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.resources.response.AlocacaoResponse;

@Component
public class AlocacaoToResponse implements ConvertFromModel<Alocacao>{

	@Override
	public Object executa(Alocacao model) {
		
		return AlocacaoResponse.builder()		
		.nomeSetor(model.getSetor().getNome())
		.nomeFuncionario(model.getFuncionario().getNomeCompleto())
		.cpf(model.getFuncionario().getCpf())
		.dataEntrada(model.getId().getDataEntrada())
		.dataSaida(model.isAtual()? null : model.getDataSaida())
		.build();
		
	}

}
