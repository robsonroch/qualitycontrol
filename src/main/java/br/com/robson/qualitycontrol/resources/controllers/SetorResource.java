package br.com.robson.qualitycontrol.resources.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.models.converters.SetorToResponse;
import br.com.robson.qualitycontrol.resources.requests.SectorRequest;
import br.com.robson.qualitycontrol.resources.response.SectorResponse;
import br.com.robson.qualitycontrol.services.SectorService;

@RestController
@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping(value = "/setores")
public class SetorResource {
		
	@Autowired
	private SectorService service;
	
	@Autowired
	private SetorToResponse builderResponse;
		
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> find(@PathVariable Long id) {
		Sector func = service.findById(id);		
				
		return ResponseEntity.ok().body(builderResponse.executa(func));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SectorRequest setorRequest) {
		
		Sector obj = service.insert(setorRequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody SectorRequest setorRequest, @PathVariable Long id) {
		
		setorRequest.setId(id);
		service.update(setorRequest);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SectorResponse>> findAll() {
		List<Sector> list = service.findAll();
		List<SectorResponse> listDto = list.stream().map(obj -> (SectorResponse) builderResponse.executa(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<SectorResponse>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Sector> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<SectorResponse> listDto = list.map(obj -> (SectorResponse) builderResponse.executa(obj));  
		return ResponseEntity.ok().body(listDto);
	}

}
