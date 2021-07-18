package br.com.robson.qualitycontrol.models.utils;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.repositories.SetorRepository;

public class AlocacaoValidator implements ConstraintValidator<AlocacaoConstraint, Allocation>{
	
	@Autowired
	private SetorRepository repo;

	@Override
	public boolean isValid(Allocation value, ConstraintValidatorContext context) {
		
		if(value == null) {
			return false;
		}
		Sector setorOpt= repo.procuraAlocacaoPeloTipo(value.getSetor().getId());
		
		return setorOpt != null;
	}

}
