package br.com.robson.qualitycontrol.models.notice.response;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoticeResponse{
	
	private Long id;
	
	private String title;
	
	private String description;
	private String acronym;
	private Long sectorId;
	private String emailFromObserver;
	private Date createdAt;
	private Date observationDate;
	private String emailFromQuality;
	private String resultClassification;
	private String descriptionPublic;

}
