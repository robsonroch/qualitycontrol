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
public class AllocationResponse {
	
	private String sectorName;
	
	private String employeeName;
	
	private String cpf;
	
	private Date startAllocationDate;
	
	private Date endAllocationDate;
	
	private String typeAllocation;
	

}
