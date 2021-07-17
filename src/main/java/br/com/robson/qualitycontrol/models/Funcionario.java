package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
public class Funcionario extends BaseEntity<Long> implements Serializable{

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Exclude
	private String nomeCompleto;

	@EqualsAndHashCode.Exclude
	@Column(unique = true)
	private String email;

	@EqualsAndHashCode.Exclude
	@Column(unique = true)
	private String cpf;

	private boolean ativo = true;

	@JsonIgnore
	@OneToMany(mappedBy = "id.funcionario")
	private Set<Alocacao> setoresAlocados = new HashSet<Alocacao>();
	
	@Builder
	public Funcionario(Long id, String nomeCompleto, String email, String cpf) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.cpf = cpf;
	}
	
	public Funcionario(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
}
