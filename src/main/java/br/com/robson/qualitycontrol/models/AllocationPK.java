package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class AllocationPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="SECTOR_ID")
	private Sector sector;
	
	@Column(name = "START_ALLOCATION_DATE")
	private Date startAllocationDate = new Date();
	
}
