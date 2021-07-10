package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@DiscriminatorValue("CHEFIA")
public class AlocacaoChefia extends Alocacao {

	private static final long serialVersionUID = 1L;

	private boolean tipoChefe = true;

}
