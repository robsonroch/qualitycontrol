package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Funcionario;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;

@Component
public class RequestToFuncionario implements ConvertToModel<Funcionario>{

	@Override
	public Funcionario executa(Object origin) {
		
		FuncionarioRequest request = (FuncionarioRequest) origin;
		 Funcionario func = Funcionario.builder()
		.ativo(true)
		.cpf(request.getCpf())
		.nomeCompleto(request.getNome().concat(" ").concat(request.getSobreNome()))
		.email(request.getEmail()).build();
		return func;
	}
	
}
