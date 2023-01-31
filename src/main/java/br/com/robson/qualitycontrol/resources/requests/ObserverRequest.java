package br.com.robson.qualitycontrol.resources.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObserverRequest {
		
	private String firstName;
	
	private String lastName;

	private String email;

	private String cpf;
	
	private Long id;

}
