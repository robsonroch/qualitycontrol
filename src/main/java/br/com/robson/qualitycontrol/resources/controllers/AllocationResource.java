package br.com.robson.qualitycontrol.resources.controllers;

import java.net.URI;

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

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.AllocationGeneric;
import br.com.robson.qualitycontrol.models.converters.AllocationToResponse;
import br.com.robson.qualitycontrol.resources.requests.AllocationRequest;
import br.com.robson.qualitycontrol.services.AllocationService;

@RestController
@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping(value = "/alocacoes")
public class AllocationResource {
			
	@Autowired
	private AllocationService alocService;
	
	@Autowired
	private AllocationToResponse builderResponse;
		
	@RequestMapping(value="/{cpf}", method=RequestMethod.GET)
	public ResponseEntity<Object> find(@PathVariable String cpf) {
		
		Allocation findByFuncionarioAndSetor = alocService.findByCpfFuncionario(cpf);
								
		return ResponseEntity.ok().body(findByFuncionarioAndSetor);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AllocationRequest objDto) {
		
		Allocation obj = alocService.insert(objDto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{cpf}").buildAndExpand(obj.getEmployee().getCpf()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AllocationRequest objDto, @PathVariable Long id) {
		
		objDto.setSectorId(id);
		alocService.update(objDto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{cpf}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String cpf) {
		alocService.desalocaFuncionario(cpf);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<AllocationGeneric>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="employeeName") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		
		Page<AllocationGeneric> list = alocService.findPageFull(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<AllocationGeneric>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="employeeName") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<AllocationGeneric> list = alocService.findPageFull(page, linesPerPage, orderBy, direction);
		
		return ResponseEntity.ok().body(list);
	}

}
