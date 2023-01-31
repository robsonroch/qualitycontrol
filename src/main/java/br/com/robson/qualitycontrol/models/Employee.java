package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "EMPLOYEE")
@PrimaryKeyJoinColumn(name="EMPLOYEE_ID")
public class Employee extends Observer{

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Exclude
	@Column(name = "CPF", unique = true)
	private String cpf;

	@Column(name = "ATIVO")
	private boolean ativo = true;

	@JsonIgnore
	@OneToMany(mappedBy = "id.employee")
	private Set<Allocation> allocationOfEmployee = new HashSet<Allocation>();
	
	@Builder
	public Employee(Long id, String firstName, String lastName, String email, String cpf) {
		super(id, firstName, lastName, email);
		this.cpf = cpf;
	}	
}
