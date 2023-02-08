package br.com.robson.qualitycontrol.models.notice.request;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class NoticeRequest {
	
	private String observationDate;
	
	private String title;
	
	private String description;
	
	private Long sectorId;
	
	private List<String> filePathEvidence;

}
