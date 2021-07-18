package br.com.robson.qualitycontrol.models.builders;

import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;
import br.com.robson.qualitycontrol.resources.requests.SetorRequest;

@Component
public class RequestToSetor implements ConvertToModel<Sector>{

	@Override
	public Sector executa(Object origin) {
		
		SetorRequest sr = (SetorRequest) origin;
		
		return Sector.builder()
		.name(sr.getNome())
		.build();
		
	}
	
}
