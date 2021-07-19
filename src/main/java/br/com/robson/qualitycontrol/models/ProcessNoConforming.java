package br.com.robson.qualitycontrol.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@PrimaryKeyJoinColumn(name="notificacaoId")
@EqualsAndHashCode(callSuper = false)
public class ProcessNoConforming extends Notice{

	private static final long serialVersionUID = 1L;
	
}
