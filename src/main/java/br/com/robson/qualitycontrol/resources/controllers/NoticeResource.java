package br.com.robson.qualitycontrol.resources.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.robson.qualitycontrol.resources.requests.NoticeRequest;

@RestController
@RequestMapping(value = "/notificacoes")
public class NoticeResource {
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ResponseEntity<Void> missConformity() {
//		
//		FuncionarioBuilder builder = new FuncionarioBuilder();
//		
//		Funcionario convertoFrom = builder.convertoFrom("Nome Completo");
						
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<@Valid NoticeRequest> insert(@Valid @RequestBody NoticeRequest objDto) {
		
		/*
		 * SlaNotice obj = service.insert(objDto); URI uri =
		 * ServletUriComponentsBuilder.fromCurrentRequest()
		 * .path("/{id}").buildAndExpand(obj.getId()).toUri();
		 */
		return ResponseEntity.ok().body(objDto);
	}	

}
