package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@DiscriminatorValue("CHEFIA")
@NoArgsConstructor
public class AlocacaoChefia extends Alocacao implements Serializable{

	private static final long serialVersionUID = 1L;

	private boolean tipoChefe = true;
	
	public AlocacaoChefia(Funcionario funcionario, Setor setor) {
		super(funcionario, setor);
	}

}
