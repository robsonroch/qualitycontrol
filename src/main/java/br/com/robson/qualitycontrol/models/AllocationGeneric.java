package br.com.robson.qualitycontrol.models;

import java.util.Date;

public interface AllocationGeneric {
	
	String getTypeAllocation();
	
	String getSectorName();
	
	String getEmployeeName();
	
	String getCpf();
	
	String getEmail();
	
	Date getStartAllocationDate();
	
	Date getEndAllocationDate();

}
