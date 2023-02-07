package br.com.robson.qualitycontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.repositories.EmployeeRepository;

@Service
public class EmployeeService extends GenericService<Employee, Long> {
	
	@Autowired
	private EmployeeRepository funcRepo;
	
	public Employee getEmployeeByCPF(String cpf) {
		return this.funcRepo.findByCpf(cpf);
	}
	
	public List<Employee> findAllSectorId(Long sectorId) {
		return this.funcRepo.findAllByAllocationOfEmployeeIdSectorId(sectorId);
	}

}
