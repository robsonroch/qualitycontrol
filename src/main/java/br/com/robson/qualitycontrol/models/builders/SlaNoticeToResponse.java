package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.models.SlaNotice;
import br.com.robson.qualitycontrol.resources.response.SetorResponse;
import br.com.robson.qualitycontrol.resources.response.SlaNoticeResponse;

@Component
public class SlaNoticeToResponse implements ConvertFromModel<SlaNotice>{

	@Override
	public Object executa(SlaNotice model) {
		
		return SlaNoticeResponse.builder()		
		.sectorName(model.getSector().getName())
		.descriptionSla(model.getTypeSla().getDescription())
		.definerCompleteName(model.getDefiner().getCompleteName())
		.cpfFromDefinerId(model.getDefiner().getCpf())
		.slaTimeStamp(model.getSlaTimeStamp())
		.build();
		
	}

}
