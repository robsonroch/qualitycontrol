package br.com.robson.qualitycontrol.resources.requests;

import lombok.Data;

@Data
public class FuncionarioRequest {
		
	private String nome;
	
	private String sobreNome;

	private String email;

	private String cpf;

}
