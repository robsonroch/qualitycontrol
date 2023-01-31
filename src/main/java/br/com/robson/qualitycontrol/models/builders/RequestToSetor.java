package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.resources.requests.SectorRequest;

@Component
public class RequestToSetor implements ConvertToModel<Sector>{

	@Override
	public Sector executa(Object origin) {
		
		SectorRequest sr = (SectorRequest) origin;
		
		return Sector.builder()
		.acronym(sr.getAcronym())
		.name(sr.getName())
		.build();
		
	}
	
}
