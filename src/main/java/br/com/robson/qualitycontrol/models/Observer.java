package br.com.robson.qualitycontrol.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OBSERVER")
@Inheritance(strategy = InheritanceType.JOINED)
public class Observer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	@Column(name = "ID")
	private Long id;

	@EqualsAndHashCode.Exclude
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@EqualsAndHashCode.Exclude
	@Column(name = "LAST_NAME")
	private String lastName;

	@EqualsAndHashCode.Exclude
	@Column(name = "EMAIL", unique = true)
	private String email;
	
	@EqualsAndHashCode.Exclude
	@Column(name = "PASSWORD", unique = true)
	private String password;
		
}
