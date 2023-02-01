package br.com.robson.qualitycontrol.resources.requests;

import br.com.robson.qualitycontrol.models.enums.TypeAssessmentAction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActionSolutionRequest {
	
	private Long actionSolutionId;
	
	private String actionTitle;
	
	private String descriptionFromBossSector;
	
	private String descriptionFromQuality;
	
	private String publicDescription;
	
	private TypeAssessmentAction typeAssessmentAction;

}
