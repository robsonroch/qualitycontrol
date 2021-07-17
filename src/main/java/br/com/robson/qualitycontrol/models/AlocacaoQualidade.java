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
@DiscriminatorValue("QUALIDADE")
@NoArgsConstructor
@AllArgsConstructor
public class AlocacaoQualidade extends Alocacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean tipoQA = true;

	public AlocacaoQualidade(Funcionario funcionario, Setor setor) {
		super(funcionario, setor);
	}

}
