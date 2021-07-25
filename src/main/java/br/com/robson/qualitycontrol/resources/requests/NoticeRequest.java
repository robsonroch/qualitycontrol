package br.com.robson.qualitycontrol.resources.requests;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class NoticeRequest {
	
	//@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate observationDate;
	private LocalDate observationDate2;
	
	private String title;

}
