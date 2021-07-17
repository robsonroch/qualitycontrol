package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SETOR_FUNCIONARIO", 
uniqueConstraints= {
		@UniqueConstraint(name ="alocacao_unica", columnNames={"dataSaida", "funcionarioId"}),
		@UniqueConstraint(name ="chefia_unica", columnNames={"dataSaida", "tipoChefe", "setorId"}),
		@UniqueConstraint(name ="qa_unico", columnNames={"dataSaida", "tipoQA", "setorId"})
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipoAlocacao", 
discriminatorType = DiscriminatorType.STRING)
public class Alocacao implements Serializable{

	private static final long serialVersionUID = 1L;
		
	private Date dataSaida = new GregorianCalendar(3000, 1 - 1, 1).getTime();
			
	@EmbeddedId
	private AlocacaoPK id = new AlocacaoPK();
	
	@Builder
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
	
	public boolean isAtual() {		
		return this.dataSaida.getTime() == new GregorianCalendar(3000, 1 - 1, 1).getTime().getTime();
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
