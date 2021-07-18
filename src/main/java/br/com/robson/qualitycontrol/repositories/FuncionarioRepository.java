package br.com.robson.qualitycontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.Employee;

@Repository
public interface FuncionarioRepository extends JpaRepository<Employee, Long> {
	
	public Employee findByCpf(String cpf);

}
