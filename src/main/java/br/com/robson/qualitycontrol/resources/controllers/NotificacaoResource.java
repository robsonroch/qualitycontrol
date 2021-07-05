package br.com.robson.qualitycontrol.resources.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/qualidade")
public class NotificacaoResource {
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ResponseEntity<Void> missConformity() {
						
		return ResponseEntity.ok().build();
	}

}
