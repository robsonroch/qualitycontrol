package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("FUNCIONARIO")
public class AlocacaoFuncionario extends Alocacao implements Serializable{

	private static final long serialVersionUID = 1L;

}