package br.com.robson.qualitycontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.User;
import br.com.robson.qualitycontrol.repositories.EmployeeRepository;
import br.com.robson.qualitycontrol.repositories.ObserverRepository;

@Service
public class ObserverService extends GenericService<User, Long> {
	
	@Autowired
	private ObserverRepository observerRepo;
	
	public User getObserverByEmail(String email) {
		return this.observerRepo.findByEmail(email);
	}

}
