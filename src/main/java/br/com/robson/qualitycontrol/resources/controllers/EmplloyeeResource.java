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

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.builders.EmployeeToResponse;
import br.com.robson.qualitycontrol.resources.requests.EmployeeRequest;
import br.com.robson.qualitycontrol.resources.response.EmployeeResponse;
import br.com.robson.qualitycontrol.services.EmployeeService;

@RestController
@RequestMapping(value = "/funcionarios")
public class EmplloyeeResource {
		
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeToResponse builderResponse;
		
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> find(@PathVariable Long id) {
		Employee func = service.findById(id);		
				
		return ResponseEntity.ok().body(builderResponse.executa(func));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EmployeeRequest objDto) {
		
		Employee obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody EmployeeRequest objDto, @PathVariable Long id) {
		
		objDto.setId(id);
		service.update(objDto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EmployeeResponse>> findAll() {
		List<Employee> list = service.findAll();
		List<EmployeeResponse> listDto = list.stream().map(obj -> (EmployeeResponse) builderResponse.executa(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<EmployeeResponse>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Employee> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<EmployeeResponse> listDto = list.map(obj -> (EmployeeResponse) builderResponse.executa(obj));  
		return ResponseEntity.ok().body(listDto);
	}

}
