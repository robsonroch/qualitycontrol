package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.resources.response.SectorResponse;

@Component
public class SetorToResponse implements ConvertFromModel<Sector>{

	@Override
	public Object executa(Sector model) {
		
		return SectorResponse.builder()		
		.name(model.getName())
		.employees(model.getEmployees())
		.id(model.getId())
		.build();
		
	}

}
