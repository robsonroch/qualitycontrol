package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@PrimaryKeyJoinColumn(name="notificacaoId")
@EqualsAndHashCode(callSuper = false)
public class HumanNonConformity extends Notificacao{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "HumanIssueId")
	private Employee issueEmployee;
}
