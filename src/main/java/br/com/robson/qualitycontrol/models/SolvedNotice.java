package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "SOLVED_NOTICE")
public class SolvedNotice implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	@Column(name = "ID")
	private Long id;
			
	@OneToOne
	@JoinColumn(name = "NOTICE_ID")
	private Notice notice;
	
	@Column(name = "SUBMISSION_DATE")
	private Date submissionDate;
	
	@OneToMany(mappedBy = "solvedNotice")
	private List<ActionSolution> actions;
	
}
