package br.com.robson.qualitycontrol.models.notice.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Notice;
import br.com.robson.qualitycontrol.models.converters.ConvertToModel;
import br.com.robson.qualitycontrol.models.notice.request.NoticeRequest;
import br.com.robson.qualitycontrol.services.SectorService;

@Component
public class RequestToNotice implements ConvertToModel<Notice>{
	
	@Autowired
	private SectorService sectorService;

	@Override
	public Notice executa(Object origin) {
		
		NoticeRequest request = (NoticeRequest) origin;
		
		Notice build = Notice.builder()
		.title(request.getTitle())
		.description(request.getDescription())
		.sectorNoticed(sectorService.getSectorByAcronym(request.getAcronym()))
.build();
				
		return build;
		
	}
	
}
