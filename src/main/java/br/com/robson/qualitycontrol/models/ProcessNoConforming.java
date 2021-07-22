package br.com.robson.qualitycontrol.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table( name = "PROCESS_NON_CONFORMING")
@PrimaryKeyJoinColumn(name="NOTICE_ID")
@EqualsAndHashCode(callSuper = false)
public class ProcessNoConforming extends Notice{

	private static final long serialVersionUID = 1L;
	
}
