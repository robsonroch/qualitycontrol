package br.com.robson.qualitycontrol.models.notice.request;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class NoticeRequest {
	
	//@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate observationDate;
	
	private String title;
	
	private String description;
	
	private String acronym;
	
	private List<String> filePathEvidence;

}
