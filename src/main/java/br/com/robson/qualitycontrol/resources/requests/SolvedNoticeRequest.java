package br.com.robson.qualitycontrol.resources.requests;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SolvedNoticeRequest {
	
	private Long solvedNoticeId;
	
	private Long noticeId;
	
	private boolean saveAndSand;
	
	private List<ActionSolutionRequest> actionSolutionRequests;

}
