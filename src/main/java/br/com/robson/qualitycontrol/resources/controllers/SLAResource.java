package br.com.robson.qualitycontrol.resources.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import br.com.robson.qualitycontrol.models.SlaNotice;
import br.com.robson.qualitycontrol.models.builders.SlaNoticeToResponse;
import br.com.robson.qualitycontrol.resources.requests.SlaNoticeRequest;
import br.com.robson.qualitycontrol.resources.response.SlaNoticeResponse;
import br.com.robson.qualitycontrol.services.SlaNoticeService;

@RestController
@RequestMapping(value = "/slas")
public class SLAResource {
	
	@Autowired
	private SlaNoticeService service;
	
	@Autowired
	private SlaNoticeToResponse builderResponse;
		
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> find(@PathVariable Long id) {
		SlaNotice func = service.findById(id);		
				
		return ResponseEntity.ok().body(builderResponse.executa(func));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SlaNoticeRequest objDto) {
		
		SlaNotice obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
//	public ResponseEntity<Void> update(@Valid @RequestBody SlaNoticeRequest objDto, @PathVariable Long id) {
//		
//		objDto.setId(id);
//		service.update(objDto);
//		return ResponseEntity.noContent().build();
//	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SlaNoticeResponse>> findAll() {
		List<SlaNotice> list = service.findAll();
		List<SlaNoticeResponse> listDto = list.stream().map(obj -> (SlaNoticeResponse) builderResponse.executa(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<SlaNoticeResponse>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<SlaNotice> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<SlaNoticeResponse> listDto = list.map(obj -> (SlaNoticeResponse) builderResponse.executa(obj));  
		return ResponseEntity.ok().body(listDto);
	}

}
