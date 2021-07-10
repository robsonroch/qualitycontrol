package br.com.robson.qualitycontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robson.qualitycontrol.models.Alocacao;

public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {

}
