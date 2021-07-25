package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.robson.qualitycontrol.models.enums.SlaEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "SLA_NOTICE", 
uniqueConstraints= {
		@UniqueConstraint(name ="SLA_UNIQUE_BY_SECTOR_TYPE", columnNames={"END_VALIDATY", "TYPE_SLA", "SECTOR_ID"})
})
@Entity
public class SlaNotice extends BaseEntity<Long> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "SECTOR_ID")
	private Sector sector;
	
	@Column(name = "SLA_TIMESTAMP")
	private Integer slaTimeStamp;
	
	@Column(name = "START_VALIDATY")
	private Date startValidaty = new Date();
	
	@Column(name = "END_VALIDATY")
	private Date endValidaty = new GregorianCalendar(3000, 1 - 1, 1).getTime();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_SLA")
	private SlaEnum typeSla;
	
	@ManyToOne
	@JoinColumn(name = "DEFINER_ID")
	private Employee definer;

}
