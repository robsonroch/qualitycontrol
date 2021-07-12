package br.com.robson.qualitycontrol.resources.controllers;

import java.net.URI;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.Alocacao.AlocacaoBuilder;
import br.com.robson.qualitycontrol.models.AlocacaoPK;
import br.com.robson.qualitycontrol.models.AlocacaoQualidade;
import br.com.robson.qualitycontrol.models.Funcionario;
import br.com.robson.qualitycontrol.models.Setor;
import br.com.robson.qualitycontrol.models.builders.RequestToFuncionario;
import br.com.robson.qualitycontrol.models.builders.RequestToSetor;
import br.com.robson.qualitycontrol.models.utils.TipoAlocacaoEnum;
import br.com.robson.qualitycontrol.repositories.AlocacaoRepository;
import br.com.robson.qualitycontrol.repositories.FuncionarioRepository;
import br.com.robson.qualitycontrol.repositories.SetorRepository;
import br.com.robson.qualitycontrol.resources.requests.AlocacaoRequest;
import br.com.robson.qualitycontrol.resources.requests.FuncionarioRequest;
import br.com.robson.qualitycontrol.resources.requests.SetorRequest;
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
		
	@RequestMapping(value="/{funcionarioId}/{setorId}", method=RequestMethod.GET)
	public ResponseEntity<Object> find(@PathVariable Long funcionarioId, @PathVariable Long setorId) {
		Funcionario func = new Funcionario();
				func.setNomeCompleto("Fulando de tal");
				func.setCpf("100.000.000.01");
				func.setEmail("fulano@email.com");
		
		Setor st = new Setor();
				st.setNome("Banco de Sangue");
		
		funcRepo.save(func);
		setorRepo.save(st);
		
		Funcionario func2 = new Funcionario();
		func2.setId(1L);
		
		Setor st2 = new Setor();
		st2.setId(1L);
		
		AlocacaoQualidade aloc = new AlocacaoQualidade(func2, st2);
		
		Alocacao save = repo.save(aloc);
						
		return ResponseEntity.ok().body(save);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AlocacaoRequest objDto) {
		
		Alocacao obj = alocService.insert(objDto);
		
		AlocacaoPK id = obj.getId();
		id.setDataEntrada(new Date());
		id.getFuncionario().setNomeCompleto(null);
		id.getFuncionario().setId(0L);
		id.getFuncionario().setAtivo(false);
		Alocacao find = alocService.findById(obj.getId());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
//	public ResponseEntity<Void> update(@Valid @RequestBody AlocacaoRequest objDto, @PathVariable Long id) {
//		
//		service.update(objDto, id);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable Long id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<List<AlocacaoResponse>> findAll() {
//		List<Alocacao> list = service.findAll();
//		List<AlocacaoResponse> listDto = list.stream().map(obj -> (AlocacaoResponse) builderResponse.executa(obj)).collect(Collectors.toList());  
//		return ResponseEntity.ok().body(listDto);
//	}
//	
//	@RequestMapping(value="/page", method=RequestMethod.GET)
//	public ResponseEntity<Page<AlocacaoResponse>> findPage(
//			@RequestParam(value="page", defaultValue="0") Integer page, 
//			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
//			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
//			@RequestParam(value="direction", defaultValue="ASC") String direction) {
//		Page<Alocacao> list = service.findPage(page, linesPerPage, orderBy, direction);
//		Page<AlocacaoResponse> listDto = list.map(obj -> (AlocacaoResponse) builderResponse.executa(obj));  
//		return ResponseEntity.ok().body(listDto);
//	}

}
