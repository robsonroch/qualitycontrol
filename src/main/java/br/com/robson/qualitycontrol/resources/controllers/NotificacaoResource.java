package br.com.robson.qualitycontrol.resources.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.robson.qualitycontrol.models.Funcionario;
import br.com.robson.qualitycontrol.models.builders.FuncionarioBuilder;

@RestController
@RequestMapping(value = "/qualidade")
public class NotificacaoResource {
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ResponseEntity<Void> missConformity() {
		
		FuncionarioBuilder builder = new FuncionarioBuilder();
		
		Funcionario convertoFrom = builder.convertoFrom("Nome Completo");
						
		return ResponseEntity.ok().build();
	}

}
