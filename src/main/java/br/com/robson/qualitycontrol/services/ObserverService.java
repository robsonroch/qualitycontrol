package br.com.robson.qualitycontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.models.User;
import br.com.robson.qualitycontrol.repositories.UserRepository;

@Service
public class ObserverService extends GenericService<User, Long> {
	
	@Autowired
	private UserRepository repo;
	
	public User findByEmail(String email) {
		return this.repo.findByEmail(email);
	}

}
