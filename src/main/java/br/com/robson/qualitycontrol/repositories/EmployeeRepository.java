package br.com.robson.qualitycontrol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByCpf(String cpf);
	
	List<Employee> findAllByAllocationOfEmployeeIdSectorId(Long sectorId);
	
}
