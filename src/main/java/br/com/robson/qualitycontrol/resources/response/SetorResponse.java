package br.com.robson.qualitycontrol.resources.response;

import java.util.List;
import java.util.Set;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetorResponse {
	
	private String name;
	
	private Long id;
	
	private List<Employee> employees;

}
