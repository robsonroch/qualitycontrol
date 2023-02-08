package br.com.robson.qualitycontrol.resources.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAllocationResponse {
	
	private String firstName;
	
	private String lastName;

	private String email;
	
	private String setor;
	
	private String allocationType;
	
	private List<String> perfis;

	private String cpf;
	
	private Long id;

}
