package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.resources.response.AlocacaoResponse;

@Component
public class AlocacaoToResponse implements ConvertFromModel<Allocation>{

	@Override
	public Object executa(Allocation model) {
		
		return AlocacaoResponse.builder()		
		.nomeSetor(model.getSetor().getName())
		.nomeFuncionario(model.getEmployee().getNomeCompleto())
		.cpf(model.getEmployee().getCpf())
		.dataEntrada(model.getId().getDataEntrada())
		.dataSaida(model.isAtual()? null : model.getDataSaida())
		.build();
		
	}

}
