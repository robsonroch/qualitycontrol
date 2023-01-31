package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import br.com.robson.qualitycontrol.models.enums.NonConformingType;
import br.com.robson.qualitycontrol.models.enums.SlaEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "NOTICE")
@ToString
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
	//Campos preenchidos na criação
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="notice")
	private SolvedNotice solvedNotice;
	
	@ManyToOne
	@JoinColumn(name="OBSERVER_ID")
	private Employee observer;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "NON_CONFORMING_TYPE")
	private NonConformingType NonConformingType;
	
	@ManyToOne
	@JoinColumn(name="QUALITY_ASSURANCE_ORIGIN_ID")
	private Employee qualityAssuranceOrigin;
	
	@OneToMany(mappedBy="notice", cascade=CascadeType.ALL)
	private List<FilePathEvidence> files = new ArrayList<>();
		
	@Column(name = "RECIDIVISM")
	private boolean recidivism;
	
	@Column(name = "SLA_NOTICE")
	private SlaNotice slaNotice;
	
	@Column(name = "NOTICED_DATE")
	private Date noticedDate;
	
	@Builder
	public Notice() {
		super();
		
	}		
			
}
