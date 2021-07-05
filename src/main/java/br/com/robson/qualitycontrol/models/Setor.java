package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Setor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer setorId;

	private String nome;
	//@Exclude
	//private Funcionario chefe;

	@OneToMany(mappedBy = "id.setor")
	private Set<Alocacao> alocacoes = new HashSet<Alocacao>();
	
	public Setor(Integer setorId, String nome, Funcionario chefe) {
		super();
		this.setorId = setorId;
		this.nome = nome;
		//this.chefe = chefe;
	}		
	
	public List<Funcionario> getFuncionarios(){
		List<Funcionario> funcionariosAtuais = new ArrayList<>();
		
		for(Alocacao alocado: alocacoes) {
			funcionariosAtuais.add(alocado.getFuncionario());
		}
		
		return funcionariosAtuais;
	}
}
