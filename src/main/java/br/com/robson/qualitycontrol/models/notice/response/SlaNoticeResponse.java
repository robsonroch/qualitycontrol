package br.com.robson.qualitycontrol.models.notice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SlaNoticeResponse {
	
	private String sectorName;

	private Integer slaTimeStamp;
		
	private String descriptionSla;
	
	private String cpfFromDefinerId;
	
	private String definerCompleteName;

}
