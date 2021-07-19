package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.robson.qualitycontrol.models.enums.SlaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "SLA_NOTICE", 
uniqueConstraints= {
		@UniqueConstraint(name ="SLA_UNIQUE_BY_SECTOR_TYPE", columnNames={"endValidity", "typeSla", "sectorId"})
})
@Entity
public class SlaDefinition extends BaseEntity<Long> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "sectorId")
	private Sector sectorId;
	
	private Long slaTimeStamp;
	
	private Date startValidity = new Date();
	
	private Date endValidity = new GregorianCalendar(3000, 1 - 1, 1).getTime();
	
	@Enumerated(EnumType.STRING)
	private SlaEnum typeSla;
	
	@ManyToOne
	@JoinColumn(name = "definerId")
	private Employee definer;

}
