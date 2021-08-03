package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.resources.response.SetorResponse;

@Component
public class SetorToResponse implements ConvertFromModel<Sector>{

	@Override
	public Object executa(Sector model) {
		
		return SetorResponse.builder()		
		.name(model.getName())
		.employees(model.getEmployees())
		.id(model.getId())
		.build();
		
	}

}
