package br.com.robson.qualitycontrol.services;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robson.qualitycontrol.exceptions.DataIntegrityException;
import br.com.robson.qualitycontrol.exceptions.ObjectNotFoundException;
import br.com.robson.qualitycontrol.models.converters.ConvertToModel;

public class GenericService<T, I> {

	@Autowired
	protected JpaRepository<T, I> repo;
	
	@Autowired
	protected ConvertToModel<T> builderModel;
		
	private Class<T> elementType;
	
	@SuppressWarnings("unchecked")
	public GenericService(){
		elementType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];	
	}

	public T findById(I id) {
		Optional<T> obj = repo.findById( id);
				
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + elementType.getName()));
	}
	
	public T insert(Object obj) {
		
		try {
			return repo.save(builderModel.executa(obj));
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Verifique o CPF/Email já em uso!");
		}
		
	}
	
	public T update(Object obj) {
		
		T model = builderModel.executa(obj);
						
		return repo.save(model);
	}
	
	public void delete(I id) {
		findById(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Funcionario que possui produtos");
		}
	}
	
	public List<T> findAll() {
		return repo.findAll();
	}
	
	public Page<T> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
		
}
