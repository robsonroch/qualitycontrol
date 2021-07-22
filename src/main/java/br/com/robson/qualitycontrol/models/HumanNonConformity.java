package br.com.robson.qualitycontrol.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "HUMAN_NON_CONFORMITY")
@PrimaryKeyJoinColumn(name="NOTICE_ID")
@EqualsAndHashCode(callSuper = false)
public class HumanNonConformity extends Notice{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "HUMAN_ISSUE_ID")
	private Employee issueEmployee;
}
