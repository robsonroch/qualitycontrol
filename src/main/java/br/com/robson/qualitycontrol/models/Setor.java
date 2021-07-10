package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Setor extends BaseEntity<Long> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Exclude
	private String nome;
		
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "id.setor")
	private Set<Alocacao> funcionariosAlocados = new HashSet<Alocacao>();
	
	public Setor(Long setorId, String nome, Funcionario chefe) {
		super();
		this.id = setorId;
		this.nome = nome;
		//this.chefe = chefe;
	}		
	
	public List<Funcionario> getFuncionarios(){
								
		return funcionariosAlocados.stream().filter(Alocacao::isAtual).map(Alocacao::getFuncionario).collect(Collectors.toList());
	}
}
