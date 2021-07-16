package br.com.robson.qualitycontrol.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.AlocacaoPK;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, AlocacaoPK> {
	
	public Alocacao findByIdFuncionarioCpf(String cpf);
	
	public List<Alocacao> findByIdFuncionarioCpfAndIdSetorId(String cpf, Long setorId);
	
	public Alocacao findByIdFuncionarioCpfAndIdSetorIdAndDataSaida(String cpf, Long setorId, Date dataSaida);
}
