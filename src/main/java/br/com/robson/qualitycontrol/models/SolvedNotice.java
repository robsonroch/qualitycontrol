package br.com.robson.qualitycontrol.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "SOLVED_NOTICE")
@EqualsAndHashCode(callSuper = false)
public class SolvedNotice extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "SEQUENCE")
	private Integer sequence;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "NOTICE_ID")
	private Notice notice;
	
	@Column(name = "SUBMISSION_DATE")
	private Date submissionDate;
	
	@Column(name = "ASSESSMENTS")
	private String assessment;
	
	@Column(name = "APPROVED")
	private boolean approved;

}
