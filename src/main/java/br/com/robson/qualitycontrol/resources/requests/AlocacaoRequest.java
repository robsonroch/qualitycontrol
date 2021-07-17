package br.com.robson.qualitycontrol.resources.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlocacaoRequest {
		
	private String cpf;
	
	private Long setorId;
	
	private String tipo;
	
}
