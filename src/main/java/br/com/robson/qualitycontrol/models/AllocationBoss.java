package br.com.robson.qualitycontrol.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@DiscriminatorValue("BOSS")
@NoArgsConstructor
public class AllocationBoss extends Allocation implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column( name = "TYPE_BOSS")
	private boolean typeBoss = true;
	
	public AllocationBoss(Employee employee, Sector sector) {
		super(employee, sector);
	}

}
