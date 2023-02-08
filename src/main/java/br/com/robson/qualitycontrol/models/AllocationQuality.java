package br.com.robson.qualitycontrol.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.robson.qualitycontrol.models.utils.AllocationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@DiscriminatorValue("QUALITY")
@NoArgsConstructor
@AllArgsConstructor
public class AllocationQuality extends Allocation{

	private static final long serialVersionUID = 1L;
	
	@Column( name = "TYPE_QUALITY")
	private boolean typeQuality = true;

	public AllocationQuality(Employee employee, Sector sector) {
		super(employee, sector, AllocationTypeEnum.QUALITY);
	}

}
