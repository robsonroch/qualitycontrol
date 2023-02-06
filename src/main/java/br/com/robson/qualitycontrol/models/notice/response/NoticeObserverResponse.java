package br.com.robson.qualitycontrol.models.notice.response;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoticeObserverResponse{
	
	private Long id;
	
	private String title;
	
	private String description;
	private String acronym;
	private String emailFromObserver;
	private Date createdAt;
	private String emailFromQuality;
	private String resultClassification;
	private String descriptionPublic;

}
