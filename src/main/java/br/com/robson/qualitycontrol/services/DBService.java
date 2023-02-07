package br.com.robson.qualitycontrol.services;

import java.text.ParseException;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.enums.Perfil;
import br.com.robson.qualitycontrol.repositories.EmployeeRepository;


@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public void instantiateTestDatabase() throws ParseException {
						
		Employee admin = Employee.builder().firstName("Robson").lastName("Rocha").email("quality.ahemo@gmail.com").password(pe.encode("111111")).cpf("07556424731").perfis(new HashSet<>()).build();
		admin.setPerfis(Perfil.ADMIN);
		admin.setPerfis(Perfil.EMPLOYEE);
		
		Employee findByCpf = employeeRepo.findByCpf(admin.getCpf());
		
		if(findByCpf != null) {
			findByCpf.setPerfis(Perfil.ADMIN);
			findByCpf.setPerfis(Perfil.EMPLOYEE);
			employeeRepo.save(findByCpf);
			
		}else {
			employeeRepo.save(admin);
		}
		
				
	}
}
