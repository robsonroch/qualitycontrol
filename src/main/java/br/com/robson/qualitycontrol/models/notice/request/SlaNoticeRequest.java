package br.com.robson.qualitycontrol.models.notice.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class SlaNoticeRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long sectorId;

	private Integer slaTimeStamp;
		
	private Integer typeSla;
	
	private String cpfFromDefinerId;
	
}
