package br.com.robson.qualitycontrol.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@DiscriminatorValue("QUALIDADE")
@NoArgsConstructor
@AllArgsConstructor
public class AllocationQuality extends Allocation{

	private static final long serialVersionUID = 1L;
	
	private boolean typeQuality = true;

	public AllocationQuality(Employee employee, Sector sector) {
		super(employee, sector);
	}

}