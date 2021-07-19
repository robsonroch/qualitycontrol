package br.com.robson.qualitycontrol.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@DiscriminatorValue("FUNCIONARIO")
@NoArgsConstructor
@AllArgsConstructor
public class AllocationEmployee extends Allocation{

	private static final long serialVersionUID = 1L;
	
	private boolean tipoFuncionario = true;
	
	public AllocationEmployee(Employee funcionario, Sector setor) {
		super(funcionario, setor);
	}

}
