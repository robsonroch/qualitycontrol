package br.com.robson.qualitycontrol.models.utils;

import javax.validation.Constraint;

import br.com.robson.qualitycontrol.models.Allocation;

@Constraint(validatedBy = { AlocacaoValidator.class })
public @interface AlocacaoConstraint {

}
