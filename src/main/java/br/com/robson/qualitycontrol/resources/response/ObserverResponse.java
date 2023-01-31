package br.com.robson.qualitycontrol.resources.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObserverResponse {
	
	private String firstName;
	
	private String lastName;

	private String email;
}
