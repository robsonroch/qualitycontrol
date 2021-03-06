package br.com.robson.qualitycontrol.resources.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import br.com.robson.qualitycontrol.models.Funcionario;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;
import br.com.robson.qualitycontrol.resources.response.FuncionarioResponse;
import br.com.robson.qualitycontrol.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioResource {
	
	//@Autowired
	//private FuncionarioService service;
		
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Funcionario> find(@PathVariable Integer id) {
		//Funcionario obj = service.find(id);
		return ResponseEntity.ok().build();
	}
	
//	@RequestMapping(method=RequestMethod.POST)
//	public ResponseEntity<Void> insert(@Valid @RequestBody FuncionarioRequest objDto) {
//		Funcionario obj = service.fromDTO(objDto);
//		obj = service.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//			.path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//	
//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
//	public ResponseEntity<Void> update(@Valid @RequestBody FuncionarioRequest objDto, @PathVariable Integer id) {
//		Categoria obj = service.fromDTO(objDto);
//		obj.setId(id);
//		obj = service.update(obj);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable Integer id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<List<FuncionarioResponse>> findAll() {
//		List<Funcionario> list = service.findAll();
//		List<FuncionarioResponse> listDto = list.stream().map(obj -> new FuncionarioResponse(obj)).collect(Collectors.toList());  
//		return ResponseEntity.ok().body(listDto);
//	}
//	
//	@RequestMapping(value="/page", method=RequestMethod.GET)
//	public ResponseEntity<Page<FuncionarioResponse>> findPage(
//			@RequestParam(value="page", defaultValue="0") Integer page, 
//			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
//			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
//			@RequestParam(value="direction", defaultValue="ASC") String direction) {
//		Page<Funcionario> list = service.findPage(page, linesPerPage, orderBy, direction);
//		Page<FuncionarioResponse> listDto = list.map(obj -> new FuncionarioResponse(obj));  
//		return ResponseEntity.ok().body(listDto);
//	}

}
