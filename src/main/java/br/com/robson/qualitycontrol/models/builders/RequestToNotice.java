package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Notice;
import br.com.robson.qualitycontrol.resources.requests.NoticeRequest;

@Component
public class RequestToNotice implements ConvertToModel<Notice>{

	@Override
	public Notice executa(Object origin) {
		
		NoticeRequest request = (NoticeRequest) origin;
		
		return Notice.builder()
		.build();
		
	}
	
}
