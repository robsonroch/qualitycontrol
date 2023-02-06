package br.com.robson.qualitycontrol.models.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.ActionSolution;
import br.com.robson.qualitycontrol.models.ActionSolution.ActionSolutionBuilder;
import br.com.robson.qualitycontrol.models.notice.request.ActionSolutionRequest;
import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.AllocationBoss;
import br.com.robson.qualitycontrol.resources.requests.AllocationRequest;
import br.com.robson.qualitycontrol.services.EmployeeService;
import br.com.robson.qualitycontrol.services.SectorService;

@Component
public class RequestToActionSoluction implements ConvertToModel<ActionSolution>{
	
	@Override
	public ActionSolution executa(Object origin) {
		ActionSolutionBuilder builder = ActionSolution.builder();
		
		ActionSolutionRequest request = (ActionSolutionRequest) origin;
		 return   ActionSolution.builder()
		 .title(request.getActionTitle())
		 .build();		 
	}
	
	private String checkDescriptionByProfile(ActionSolutionBuilder request) {
		
		return "title to user in login";
		
	}
	
}
