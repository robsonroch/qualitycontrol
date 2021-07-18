package br.com.robson.qualitycontrol.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Notificacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@Lob
	private String description;
	
	@ManyToOne
	@JoinColumn(name="setorId")
	private Sector setorNotificado;
	
	@ManyToOne
	@JoinColumn(name="observerId")
	private Employee observer;
	
	@ManyToOne
	@JoinColumn(name="qualityAssuranceOriginId")
	private Employee responsavelOriginal;
	
	@ManyToOne
	@JoinColumn(name="qualityAssuranceInheritedId")
	private Employee responsavelPorAtual;
		
}
