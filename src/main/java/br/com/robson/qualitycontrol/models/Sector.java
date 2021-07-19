package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Sector extends BaseEntity<Long> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Exclude
	private String name;
		
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "id.sector")
	@JsonIgnore
	private Set<Allocation> allocatedEmployees = new HashSet<Allocation>();
	
	@Builder
	public Sector(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}		
	
	public List<Employee> getEmployees(){
								
		return allocatedEmployees.stream().filter(Allocation::isActual).map(Allocation::getEmployee).collect(Collectors.toList());
	}
}
