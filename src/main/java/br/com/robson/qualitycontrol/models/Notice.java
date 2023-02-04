package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import br.com.robson.qualitycontrol.models.enums.NonConformingType;
import br.com.robson.qualitycontrol.models.enums.SlaEnum;
import br.com.robson.qualitycontrol.models.enums.NoticeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "NOTICE")
@NoArgsConstructor
@AllArgsConstructor
public class Notice implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Campos preenchidos na criação
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Lob
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="SECTOR_ID")
	private Sector sectorNoticed;
	
	@ManyToOne
	@JoinColumn(name="OBSERVER_ID")
	private User observer;
	
	@OneToMany(mappedBy="notice", cascade=CascadeType.ALL)
	private List<FilePathEvidence> files = new ArrayList<>();
	
	@CreatedDate
	@Column(name = "CREATED_AT")
	private Date createdAt;
	//Fim Campos da criação
	
	//Campos para classificação		
	@ManyToOne
	@JoinColumn(name="QUALITY_ASSURANCE_ORIGIN_ID")
	private Employee qualityAssuranceOrigin;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "NON_CONFORMING_TYPE")
	private NonConformingType NonConformingType;
	
	@Column(name = "RECIDIVISM")
	private boolean recidivism;
	
	@Column(name = "SLA_NOTICE")
	private SlaNotice slaNotice;
	
	@Lob
	@Column(name = "DESCRIPTION_INTERNAL")
	private String descriptionInternal;
	
	@Lob
	@Column(name = "DESCRIPTION_PUBLIC")
	private String descriptionPublic;
	
	//Campos para classificação
	//Compos de resolução
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SOLVED_NOTICE_STATUS")
	private NoticeStatus noticeStatus = NoticeStatus.RECEIVED;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="notice")
	private SolvedNotice solvedNotice;
			
	@Builder
	public Notice(String title, String description, Sector sectorNoticed) {
		super();
		this.title = title;
		this.description = description;
		this.sectorNoticed = sectorNoticed;
	}
			
}
