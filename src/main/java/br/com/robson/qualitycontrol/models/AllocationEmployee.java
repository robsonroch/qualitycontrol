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
@DiscriminatorValue("EMPLOYEE")
@NoArgsConstructor
@AllArgsConstructor
public class AllocationEmployee extends Allocation{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "TYPE_EMPLOYEE")
	private boolean typeEmployee = true;
	
	public AllocationEmployee(Employee funcionario, Sector setor) {
		super(funcionario, setor, AllocationTypeEnum.EMPLOYEE);
	}

}
