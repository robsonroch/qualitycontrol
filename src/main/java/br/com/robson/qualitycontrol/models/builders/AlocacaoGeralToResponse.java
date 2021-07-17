package br.com.robson.qualitycontrol.models.builders;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.AlocacaoGeral;
import br.com.robson.qualitycontrol.resources.response.AlocacaoResponse;

@Component
public class AlocacaoGeralToResponse implements ConvertFromModel<AlocacaoGeral>{

	private Date dataSaida = new GregorianCalendar(3000, 1 - 1, 1).getTime();
	
	@Override
	public Object executa(AlocacaoGeral model) {
		
		return AlocacaoResponse.builder()		
		.nomeSetor(model.getNomeSetor())
		.nomeFuncionario(model.getNomeFuncionario())
		.tipoAlocacao(model.getTipoAlocacao())
		.cpf(model.getCpf())
		.dataEntrada(model.getDataEntrada())
		//.dataSaida(this.dataSaida.getTime() == new GregorianCalendar(3000, 1 - 1, 1).getTime().getTime() ? null : model.getDataSaida())
		.build();
		
	}

}
