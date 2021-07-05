package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Alocacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date dataSaida;
	
	@EmbeddedId
	private AlocacaoPK id = new AlocacaoPK();
	
	public Alocacao(Funcionario funcionario, Setor setor) {
		this.id.setFuncionario(funcionario);
		this.id.setSetor(setor);
	}
	
	public Funcionario getFuncionario() {
		return this.id.getFuncionario();
	}
	
	public Setor getSetor() {
		return this.id.getSetor();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alocacao other = (Alocacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
}
