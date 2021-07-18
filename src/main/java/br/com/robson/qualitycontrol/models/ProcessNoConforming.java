package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@PrimaryKeyJoinColumn(name="notificacaoId")
@EqualsAndHashCode(callSuper = false)
public class ProcessNoConforming extends Notificacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
}
