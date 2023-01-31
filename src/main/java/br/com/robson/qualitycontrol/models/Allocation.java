package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SECTOR_EMPLOYEE", 
uniqueConstraints= {
		@UniqueConstraint(name ="EMPLOYEE_UNIQUE_ALLOCATION", columnNames={"END_ALLOCATION_DATE", "EMPLOYEE_ID"}),
		@UniqueConstraint(name ="BOSS_ONLY_ONE", columnNames={"END_ALLOCATION_DATE", "TYPE_BOSS", "SECTOR_ID"}),
		@UniqueConstraint(name ="QA_ONLY_ONE", columnNames={"END_ALLOCATION_DATE", "TYPE_QUALITY", "SECTOR_ID"})
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_ALLOCATION", 
discriminatorType = DiscriminatorType.STRING)
public class Allocation implements Serializable{

	private static final long serialVersionUID = 1L;
		
	@Column(name = "END_ALLOCATION_DATE")
	private Date endAllocationDate = new GregorianCalendar(3000, 1 - 1, 1).getTime();
			
	@EmbeddedId
	private AllocationPK id = new AllocationPK();
	
	@Builder
	public Allocation(Employee employee, Sector sector) {
		this.id.setEmployee(employee);
		this.id.setSector(sector);
	}

	public Employee getEmployee() {
		return this.id.getEmployee();
	}

	public Sector getSector() {
		return this.id.getSector();
	}
	
	public boolean isActual() {		
		return this.endAllocationDate.getTime() == new GregorianCalendar(3000, 1 - 1, 1).getTime().getTime();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Allocation other = (Allocation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
}
