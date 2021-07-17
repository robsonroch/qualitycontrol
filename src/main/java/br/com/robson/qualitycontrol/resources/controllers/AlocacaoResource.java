package br.com.robson.qualitycontrol.resources.controllers;

import java.net.URI;
import java.util.Date;
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

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.Alocacao.AlocacaoBuilder;
import br.com.robson.qualitycontrol.models.AlocacaoGeral;
import br.com.robson.qualitycontrol.models.AlocacaoPK;
import br.com.robson.qualitycontrol.models.AlocacaoQualidade;
import br.com.robson.qualitycontrol.models.Funcionario;
import br.com.robson.qualitycontrol.models.Setor;
import br.com.robson.qualitycontrol.models.builders.AlocacaoGeralToResponse;
import br.com.robson.qualitycontrol.models.builders.AlocacaoToResponse;
import br.com.robson.qualitycontrol.models.builders.FuncionarioToResponse;
import br.com.robson.qualitycontrol.models.builders.RequestToFuncionario;
import br.com.robson.qualitycontrol.models.builders.RequestToSetor;
import br.com.robson.qualitycontrol.models.builders.SetorToResponse;
import br.com.robson.qualitycontrol.models.utils.TipoAlocacaoEnum;
import br.com.robson.qualitycontrol.repositories.AlocacaoRepository;
import br.com.robson.qualitycontrol.repositories.FuncionarioRepository;
import br.com.robson.qualitycontrol.repositories.SetorRepository;
import br.com.robson.qualitycontrol.resources.requests.AlocacaoRequest;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;
import br.com.robson.qualitycontrol.resources.requests.SetorRequest;
import br.com.robson.qualitycontrol.resources.response.AlocacaoResponse;
import br.com.robson.qualitycontrol.services.AlocacaoService;
import br.com.robson.qualitycontrol.services.FuncionarioService;
import br.com.robson.qualitycontrol.services.SetorService;

@RestController
@RequestMapping(value = "/alocacoes")
public class AlocacaoResource {
		
	@Autowired
	private SetorService stService;
	
	@Autowired
	private FuncionarioService funcService;
	
	@Autowired
	private AlocacaoService alocService;
	
	@Autowired
	private RequestToFuncionario rqToFuncionario;
	
	@Autowired
	private RequestToSetor rqToSetor;
	
	@Autowired
	private AlocacaoRepository repo;
	
	@Autowired
	private FuncionarioRepository funcRepo;
	
	@Autowired
	private SetorRepository setorRepo;
	
	@Autowired
	private AlocacaoToResponse builderResponse;
	
	@Autowired
	private AlocacaoGeralToResponse builderAlocacaoFull;
		
	@RequestMapping(value="/{cpf}/{setorId}", method=RequestMethod.GET)
	public ResponseEntity<Object> find(@PathVariable String cpf, @PathVariable Long setorId) {
		
		Alocacao findByFuncionarioAndSetor = alocService.findByCpfFuncionario(cpf);
								
		return ResponseEntity.ok().body(findByFuncionarioAndSetor);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AlocacaoRequest objDto) {
		
		Alocacao obj = alocService.insert(objDto);
		
		AlocacaoPK id = obj.getId();
		
		Alocacao find = alocService.findAtualLocacaoByCpf(id.getFuncionario().getCpf(), id.getSetor().getId());
		String cpf = find.getFuncionario().getCpf();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
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
		Alocacao desalocaFuncionario = alocService.desalocaFuncionario(cpf);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<AlocacaoGeral>> findAll(@RequestParam(value="direction", defaultValue="ASC") String direction) {
		
		List<AlocacaoGeral> findAllTipo = repo.findAllTipo();
		List<AlocacaoResponse> listDto = findAllTipo.stream().map(obj -> (AlocacaoResponse) builderAlocacaoFull.executa(obj)).collect(Collectors.toList());  
		Page<AlocacaoGeral> list = alocService.findPageFull(direction);
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
