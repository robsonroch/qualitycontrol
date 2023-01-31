package br.com.robson.qualitycontrol.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		@UniqueConstraint(name ="SLA_UNIQUE_BY_SECTOR_TYPE", columnNames={"SLA_TIMESTAMP", "TYPE_SLA", "SECTOR_ID"})
})
@Entity
public class SlaNotice implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "SECTOR_ID")
	private Sector sector;
	
	@Column(name = "SLA_TIMESTAMP")
	private Integer slaTimeStamp;
			
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_SLA")
	private SlaEnum typeSla;
	
}
