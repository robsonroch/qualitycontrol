package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;

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
public class AlocacaoFuncionario extends Alocacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean tipoFuncionario = true;
	
	public AlocacaoFuncionario(Funcionario funcionario, Setor setor) {
		super(funcionario, setor);
	}

}
