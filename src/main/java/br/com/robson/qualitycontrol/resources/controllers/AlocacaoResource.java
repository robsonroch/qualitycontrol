package br.com.robson.qualitycontrol.resources.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.AlocacaoGeral;
import br.com.robson.qualitycontrol.models.builders.AlocacaoToResponse;
import br.com.robson.qualitycontrol.resources.requests.AlocacaoRequest;
import br.com.robson.qualitycontrol.resources.response.AlocacaoResponse;
import br.com.robson.qualitycontrol.services.AlocacaoService;

@RestController
@RequestMapping(value = "/alocacoes")
public class AlocacaoResource {
			
	@Autowired
	private AlocacaoService alocService;
	
	@Autowired
	private AlocacaoToResponse builderResponse;
		
	@RequestMapping(value="/{cpf}", method=RequestMethod.GET)
	public ResponseEntity<Object> find(@PathVariable String cpf) {
		
		Alocacao findByFuncionarioAndSetor = alocService.findByCpfFuncionario(cpf);
								
		return ResponseEntity.ok().body(findByFuncionarioAndSetor);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AlocacaoRequest objDto) {
		
		Alocacao obj = alocService.insert(objDto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{cpf}").buildAndExpand(obj.getFuncionario().getCpf()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AlocacaoRequest objDto, @PathVariable Long id) {
		
		objDto.setSetorId(id);
		alocService.update(objDto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{cpf}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String cpf) {
		alocService.desalocaFuncionario(cpf);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<AlocacaoGeral>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		
		Page<AlocacaoGeral> list = alocService.findPageFull(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<AlocacaoResponse>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Alocacao> list = alocService.findPage(page, linesPerPage, orderBy, direction);
		Page<AlocacaoResponse> listDto = list.map(obj -> (AlocacaoResponse) builderResponse.executa(obj));  
		return ResponseEntity.ok().body(listDto);
	}

}
