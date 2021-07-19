package br.com.robson.qualitycontrol.models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
public class Notice extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
	private String title;
	
	@Lob
	private String description;
	
	@ManyToOne
	@JoinColumn(name="sectorId")
	private Sector sectorNoticed;
	
	@ManyToOne
	@JoinColumn(name="observerId")
	private Employee observer;
	
	@ManyToOne
	@JoinColumn(name="qualityAssuranceOriginId")
	private Employee qualityAssuranceOrigin;
	
	@ManyToOne
	@JoinColumn(name="qualityAssuranceInheritedId")
	private Employee qualityAssuranceInherited;
		
}
