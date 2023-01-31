package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import br.com.robson.qualitycontrol.models.enums.NonConformingType;
import br.com.robson.qualitycontrol.models.enums.NoticeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NOTICE")
@NoArgsConstructor
@AllArgsConstructor
public class ActionSolution implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Campos preenchidos na criação
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Lob
	@Column(name = "DESCRIPTION")
	private String description;

}
