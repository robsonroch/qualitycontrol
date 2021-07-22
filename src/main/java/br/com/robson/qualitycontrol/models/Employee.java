package br.com.robson.qualitycontrol.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Exclude
	@Column(name = "COMPLETE_NAME")
	private String completeName;

	@EqualsAndHashCode.Exclude
	@Column(name = "EMAIL", unique = true)
	private String email;

	@EqualsAndHashCode.Exclude
	@Column(name = "CPF", unique = true)
	private String cpf;

	@Column(name = "ATIVO")
	private boolean ativo = true;

	@JsonIgnore
	@OneToMany(mappedBy = "id.employee")
	private Set<Allocation> allocationOfEmployee = new HashSet<Allocation>();
	
	@Builder
	public Employee(Long id, String completeName, String email, String cpf) {
		super();
		this.id = id;
		this.completeName = completeName;
		this.email = email;
		this.cpf = cpf;
	}
	
	public Employee(String completeName) {
		this.completeName = completeName;
	}
	
}
