package br.com.robson.qualitycontrol.models.utils;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.Setor;
import br.com.robson.qualitycontrol.repositories.SetorRepository;

public class AlocacaoValidator implements ConstraintValidator<AlocacaoConstraint, Alocacao>{
	
	@Autowired
	private SetorRepository repo;

	@Override
	public boolean isValid(Alocacao value, ConstraintValidatorContext context) {
		
		if(value == null) {
			return false;
		}
		Setor setorOpt= repo.procuraAlocacaoPeloTipo(value.getSetor().getId());
		
		return setorOpt != null;
	}

}
