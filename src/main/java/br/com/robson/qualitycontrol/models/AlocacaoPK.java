package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Embeddable
@Getter
@Setter
public class AlocacaoPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="funcionarioId")
	private Funcionario funcionario;
	@ManyToOne
	@JoinColumn(name="setorId")
	private Setor setor;
	
	private Date dataEntrada = new Date();

}
