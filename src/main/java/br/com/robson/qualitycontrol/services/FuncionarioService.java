package br.com.robson.qualitycontrol.services;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.repositories.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService extends Servico<Employee, Long> {
	
	@Autowired
	private FuncionarioRepository funcRepo;
	
	public Employee getEmployeeByCPF(String cpf) {
		return this.funcRepo.findByCpf(cpf);
	}

}
