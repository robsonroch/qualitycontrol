package br.com.robson.qualitycontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.AlocacaoPK;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, AlocacaoPK> {
	
	public Alocacao findByAlocacaoPKFuncionarioEmailEqual(String email);

}
