package br.com.robson.qualitycontrol.resources.requests;

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
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class SlaNoticeRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long sectorId;

	private Integer slaTimeStamp;
		
	private Integer typeSla;
	
	private String cpfFromDefinerId;
	
}
