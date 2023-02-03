package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.robson.qualitycontrol.models.enums.NonConformingType;
import br.com.robson.qualitycontrol.models.enums.NoticeStatus;
import br.com.robson.qualitycontrol.models.enums.TypeAssessmentAction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ACTION_SOLUTION")
@NoArgsConstructor
@AllArgsConstructor
public class ActionSolution implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Campos preenchidos na criação
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TITLE")
	private String title;
	
	@ManyToOne
	@JoinColumn(name="SOLVED_NOTICE_ID")
	private SolvedNotice solvedNotice;
	
	@Lob
	@Column(name = "DESCRIPTION_BOSS")
	private String descriptionFromBossSector;
	
	@Lob
	@Column(name = "DESCRIPTION_QUALITY")
	private String descriptionFromQuality;
	
	@Lob
	@Column(name = "PUBLIC_DESCRIPTION")
	private String publicDescription;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_ASSESSEMENT_ACTION")
	private TypeAssessmentAction typeAssessmentAction;
	
	@Builder
	public ActionSolution(String title, String descriptionFromBossSector, SolvedNotice solvedNotice) {
		this.title = title;
		this.descriptionFromBossSector = descriptionFromBossSector;
		this.solvedNotice = solvedNotice;
		this.typeAssessmentAction= TypeAssessmentAction.DEFINING;
		
	}
	
	
	
}
