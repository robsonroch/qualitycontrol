package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import br.com.robson.qualitycontrol.models.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OBSERVER")
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public class User implements Serializable{

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

	@Column(name = "EMAIL", unique = true)
	private String email;
	
	@Column(name = "SENHA", unique = true)
	private String password;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS", joinColumns=@JoinColumn(name="EMAIL"))
	private Set<Integer> perfis = new HashSet<>();
	
	public Set<Perfil> getPerfis(){
		return perfis.stream().map(code -> Perfil.toEnum(code)).collect(Collectors.toSet());
	}
	
	public void setPerfis(Perfil perfil){
		perfis.add(perfil.getCod());
	}
	
}
