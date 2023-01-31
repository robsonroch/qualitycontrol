package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table( name = "SECTOR")
@NoArgsConstructor
@AllArgsConstructor
public class Sector implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@EqualsAndHashCode.Exclude
	@Column(name = "NAME")
	@NotEmpty
	private String name;
	
	@EqualsAndHashCode.Exclude
	@Column(name = "ACRONYM")
	@NotEmpty
	private String acronym;
		
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "id.sector")
	@JsonIgnore
	private Set<Allocation> allocatedEmployees = new HashSet<Allocation>();
	
	@Builder
	public Sector(Long id, String name, String acronym) {
		super();
		this.id = id;
		this.name = name;
		this.acronym = acronym;
	}		
	
	public List<Employee> getEmployees(){
								
		return allocatedEmployees.stream().filter(Allocation::isActual).map(Allocation::getEmployee).collect(Collectors.toList());
	}
}
