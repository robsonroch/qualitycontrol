package br.com.robson.qualitycontrol.services;

import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

//	@Autowired
//	private FuncionarioRepository repo;
//
//	public Funcionario find(Integer id) {
//		Optional<Funcionario> obj = repo.findById(id);
//		return obj.orElseThrow(() -> new ObjectNotFoundException(
//				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
//	}
//	
//	public Funcionario insert(Funcionario obj) {
//		obj.setId(null);
//		return repo.save(obj);
//	}
//	
//	public Funcionario update(Funcionario obj) {
//		
//		return repo.save(obj);
//	}
//	
//	public void delete(Integer id) {
//		find(id);
//		try {
//			repo.deleteById(id);
//		}
//		catch (DataIntegrityViolationException e) {
//			throw new DataIntegrityException("Não é possível excluir uma Funcionario que possui produtos");
//		}
//	}
//	
//	public List<Funcionario> findAll() {
//		return repo.findAll();
//	}
//	
//	public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return repo.findAll(pageRequest);
//	}
		
}
