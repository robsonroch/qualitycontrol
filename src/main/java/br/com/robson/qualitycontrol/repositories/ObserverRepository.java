package br.com.robson.qualitycontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.User;

@Repository
public interface ObserverRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String cpf);

}
