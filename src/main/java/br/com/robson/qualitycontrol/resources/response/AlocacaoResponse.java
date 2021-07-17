package br.com.robson.qualitycontrol.resources.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlocacaoResponse {
	
	private String nomeSetor;
	
	private String nomeFuncionario;
	
	private String cpf;
	
	private Date dataEntrada;
	
	private Date dataSaida;
	
	private String tipoAlocacao;
	

}
