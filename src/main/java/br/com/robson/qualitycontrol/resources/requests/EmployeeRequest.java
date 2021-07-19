package br.com.robson.qualitycontrol.resources.requests;

import lombok.Data;

@Data
public class EmployeeRequest {
		
	private String firstName;
	
	private String lastName;

	private String email;

	private String cpf;
	
	private Long id;

}
