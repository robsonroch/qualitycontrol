package br.com.robson.qualitycontrol.models.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.ActionSolution;
import br.com.robson.qualitycontrol.models.SolvedNotice;
import br.com.robson.qualitycontrol.resources.requests.SolvedNoticeRequest;
import br.com.robson.qualitycontrol.services.NoticeService;

@Component
public class RequestToSolvedNotice implements ConvertToModel<SolvedNotice> {

	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private RequestToActionSoluction toAction;

	@Override
	public SolvedNotice executa(Object origin) {

		SolvedNoticeRequest request = (SolvedNoticeRequest) origin;

		SolvedNotice build = SolvedNotice.builder()
				.notice(noticeService.findById(request.getNoticeId()))
				.actions(getActionFromRequest(request))
				.build();

		return build;

	}
	
	private List<ActionSolution> getActionFromRequest(SolvedNoticeRequest request){
		return request.getActionSolutionRequests()
				.stream()
				.map(requestAction -> toAction.executa(requestAction)).collect(Collectors.toList());
	}

}
