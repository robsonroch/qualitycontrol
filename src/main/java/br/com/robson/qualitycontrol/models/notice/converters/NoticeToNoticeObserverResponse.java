package br.com.robson.qualitycontrol.models.notice.converters;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Notice;
import br.com.robson.qualitycontrol.models.converters.ConvertFromModel;
import br.com.robson.qualitycontrol.models.notice.response.NoticeObserverResponse;

@Component
public class NoticeToNoticeObserverResponse implements ConvertFromModel<Notice>{

	@Override
	public NoticeObserverResponse executa(Notice model) {
		
		return NoticeObserverResponse.builder()	
				.id(model.getId())
				.title(model.getTitle())
				.description(model.getDescription())
				.acronym(model.getSectorNoticed().getAcronym())
				.emailFromObserver(model.getObserver().getEmail())
				.createdAt(model.getCreatedAt())
				.emailFromQuality(model.getQualityAssuranceOrigin().getEmail())
				.resultClassification(model.getNonConformingType().getDescription())
				.descriptionPublic(model.getDescriptionPublic())
				.build();
		
	}

}
