package br.com.robson.qualitycontrol.models.notice.converters;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.SlaNotice;
import br.com.robson.qualitycontrol.models.converters.ConvertFromModel;
import br.com.robson.qualitycontrol.models.notice.response.SlaNoticeResponse;

@Component
public class SlaNoticeToResponse implements ConvertFromModel<SlaNotice>{

	@Override
	public Object executa(SlaNotice model) {
		
		return SlaNoticeResponse.builder()		
		.sectorName(model.getSector().getName())
		.descriptionSla(model.getTypeSla().getDescription())
		.slaTimeStamp(model.getSlaTimeStamp())
		.build();
		
	}

}
