package br.com.robson.qualitycontrol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.robson.qualitycontrol.exceptions.ObjectNotFoundException;
import br.com.robson.qualitycontrol.models.User;
import br.com.robson.qualitycontrol.models.converters.RequestToUser;
import br.com.robson.qualitycontrol.models.converters.UserToResponse;
import br.com.robson.qualitycontrol.models.enums.Perfil;
import br.com.robson.qualitycontrol.repositories.UserRepository;
import br.com.robson.qualitycontrol.resources.requests.UserRequest;
import br.com.robson.qualitycontrol.security.jwt.UserSS;
import br.com.robson.qualitycontrol.services.exception.AuthorizationException;
import br.com.robson.qualitycontrol.services.exception.DataIntegrityException;

@Service
public class ObserverService  {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RequestToUser converter;
	
	@Autowired
	private UserToResponse toResponse;
		
	@Autowired
	private BCryptPasswordEncoder pe;
			
	public User find(Long id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}
	
	@Transactional
	public User insert(UserRequest obj) {
		User newUser = converter.executa(obj);
		newUser.setId(null);
		User onBase = repo.save(newUser);

		return onBase;
	}
	
	public User update(UserRequest obj) {
		User fromRequest = converter.executa(obj);
		User fromBase = find(obj.getId());
		updateData(fromRequest, fromBase);
		return repo.save(fromRequest);
	}

	public void delete(Long id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
	
		User obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + User.class.getName());
		}
		return obj;
	}
	
	public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
			
	private void updateData(User newObj, User obj) {
		newObj.setFirstName(obj.getFirstName());
		newObj.setLastName(obj.getLastName());
		newObj.setEmail(obj.getEmail());
	}
	
}
