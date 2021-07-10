package br.com.robson.qualitycontrol.resources.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioResponse {
	
	private String nome;
	
	private String sobreNome;

	private String email;

	private String cpf;

}
