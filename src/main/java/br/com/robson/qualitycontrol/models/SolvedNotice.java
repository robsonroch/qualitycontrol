package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.ArrayList;
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

import br.com.robson.qualitycontrol.models.enums.NonConformingType;
import br.com.robson.qualitycontrol.models.enums.NoticeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "SOLVED_NOTICE")
@NoArgsConstructor
@AllArgsConstructor
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
	
	@Column(name = "PROPOSED_DEAD_LINE")
	private Date proposedDeadline;
	
	@Column(name = "DEFINED_DEAD_LINE")
	private Date definedDeadline;
	
	@OneToMany(mappedBy = "solvedNotice")
	private List<ActionSolution> actions = new ArrayList<>();
	
	@Builder
	public SolvedNotice(Notice notice, List<ActionSolution> actions) {
		super();
		this.notice = notice;
	}
	
}
