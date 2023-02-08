package br.com.robson.qualitycontrol.resources.controllers;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

import br.com.robson.qualitycontrol.models.User;
import br.com.robson.qualitycontrol.models.converters.UserToResponse;
import br.com.robson.qualitycontrol.profile.service.FeaturePerfil;
import br.com.robson.qualitycontrol.profile.service.FeatureProfileHandleService;
import br.com.robson.qualitycontrol.profile.service.MapPerfis;
import br.com.robson.qualitycontrol.resources.requests.UserRequest;
import br.com.robson.qualitycontrol.resources.response.ObserverResponse;
import br.com.robson.qualitycontrol.services.ObserverService;

@RestController
@RequestMapping(value="/observers")
public class UserResource {
	
	@Autowired
	private ObserverService service;
	
	@Autowired
	private UserToResponse converter;
	
	@PreAuthorize("hasAnyRole('OBSERVER')")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> find(@PathVariable Long id) {
		User obj = service.findUserFromToken(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<ObserverResponse> find(@RequestParam(value="value") String email) {
		User obj = service.findByEmail(email);	
		
		return ResponseEntity.ok().body(converter.executa(obj));
	}
	
	@RequestMapping(value="/permissions", method=RequestMethod.GET)
	public ResponseEntity<Map<String, FeaturePerfil>> findPermission() {
		
		return ResponseEntity.ok().body(service.getFeaturePerfil());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UserRequest objDto) {
		User obj = service.insert(objDto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('OBSERVER')")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UserRequest objDto, @PathVariable Long id) {
		objDto.setId(id);
		service.update(objDto);

		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ObserverResponse>> findAll() {
		List<User> list = service.findAll();
		List<ObserverResponse> listDto = list.stream().map(obj -> converter.executa(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ObserverResponse>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<User> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ObserverResponse> listDto = list.map(obj -> converter.executa(obj));  
		return ResponseEntity.ok().body(listDto);
	}	
	
}
