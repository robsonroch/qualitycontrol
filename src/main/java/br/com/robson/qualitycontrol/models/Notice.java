package br.com.robson.qualitycontrol.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "NOTICE")
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
public class Notice extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
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
	private Employee observer;
	
	@ManyToOne
	@JoinColumn(name="QUALITY_ASSURANCE_ORIGIN_ID")
	private Employee qualityAssuranceOrigin;
		
	@Column(name = "RECIDIVISM")
	private boolean recidivism;
	
	@Column(name = "SLA_NOTICE")
	private SlaNotice slaNotice;
	
	@Column(name = "NOTICED_DATE")
	private Date noticedDate;
			
}
