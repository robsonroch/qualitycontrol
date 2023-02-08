package br.com.robson.qualitycontrol.models.notice.converters;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.converters.ConvertFromModel;
import br.com.robson.qualitycontrol.models.notice.Notice;
import br.com.robson.qualitycontrol.models.notice.response.NoticeResponse;

@Component
public class NoticeToNoticeResponse implements ConvertFromModel<Notice>{

	@Override
	public NoticeResponse executa(Notice model) {
				
		return NoticeResponse.builder()	
				.id(model.getId())
				.title(model.getTitle())
				.description(model.getDescription())
				.acronym(model.getSectorNoticed().getAcronym())
				.sectorId(model.getSectorNoticed().getId())
				.emailFromObserver(model.getObserver().getEmail())
				.observationDate(model.getObservationDate())
				.emailFromQuality(model.getQualityAssuranceOrigin().getEmail())
				.resultClassification(model.getNonConformingType().getDescription())
				.descriptionPublic(model.getDescriptionPublic())
				.build();
		
	}

}
