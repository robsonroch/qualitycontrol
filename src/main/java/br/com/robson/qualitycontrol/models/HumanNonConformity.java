package br.com.robson.qualitycontrol.models;

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
public class HumanNonConformity extends Notice{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "HumanIssueId")
	private Employee issueEmployee;
}
