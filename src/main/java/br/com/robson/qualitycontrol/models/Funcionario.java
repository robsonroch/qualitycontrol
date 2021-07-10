package br.com.robson.qualitycontrol.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=false)
public class Funcionario extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;

	private String nomeCompleto;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String cpf;

	private boolean ativo;
		
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "id.funcionario")
	private Set<Alocacao> setoresAlocados = new HashSet<Alocacao>();
	
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
