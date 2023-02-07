package br.com.robson.qualitycontrol.models.converters;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.ActionSolution;
import br.com.robson.qualitycontrol.models.ActionSolution.ActionSolutionBuilder;
import br.com.robson.qualitycontrol.models.notice.request.ActionSolutionRequest;

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
