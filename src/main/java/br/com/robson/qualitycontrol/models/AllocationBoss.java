package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@DiscriminatorValue("BOSS")
@NoArgsConstructor
@Table(name = "SECTOR_EMPLOYEE", 
uniqueConstraints= {
		@UniqueConstraint(name ="chefia_unica", columnNames={"dataSaida", "setorId"})
})
public class AllocationBoss extends Allocation implements Serializable{

	private static final long serialVersionUID = 1L;

	private boolean tipoChefe = true;
	
	public AllocationBoss(Employee employee, Sector sector) {
		super(employee, sector);
	}

}
