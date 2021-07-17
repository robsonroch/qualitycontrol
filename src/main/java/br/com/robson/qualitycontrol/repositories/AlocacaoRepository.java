package br.com.robson.qualitycontrol.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.AlocacaoGeral;
import br.com.robson.qualitycontrol.models.AlocacaoPK;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, AlocacaoPK> {

	public Alocacao findByIdFuncionarioCpf(String cpf);

	public List<Alocacao> findByIdFuncionarioCpfAndIdSetorId(String cpf, Long setorId);

	public Alocacao findByIdFuncionarioCpfAndIdSetorIdAndDataSaida(String cpf, Long setorId, Date dataSaida);

	@Query(nativeQuery = true, value = "SELECT A.TIPO_ALOCACAO AS tipoAlocacao, A.DATA_ENTRADA AS dataEntrada, "
			+ "F.NOME_COMPLETO AS nomeFuncionario, F.CPF AS cpf, F.EMAIL AS email, " + "S.NOME AS nomeSetor "
			+ "FROM SETOR_FUNCIONARIO A " + "LEFT JOIN FUNCIONARIO F " + "ON A.FUNCIONARIO_ID = F.ID "
			+ "LEFT JOIN SETOR S " + "ON A.SETOR_ID = S.ID " + "WHERE DATA_SAIDA = '3000-01-01 00:00:00	'")
	public List<AlocacaoGeral> findAllTipo();

	@Query(nativeQuery = true, value = "SELECT A.TIPO_ALOCACAO AS tipoAlocacao, A.DATA_ENTRADA AS dataEntrada, "
			+ "F.NOME_COMPLETO AS nomeFuncionario, F.CPF AS cpf, F.EMAIL AS email, " + "S.NOME AS nomeSetor "
			+ "FROM SETOR_FUNCIONARIO A " + "LEFT JOIN FUNCIONARIO F " + "ON A.FUNCIONARIO_ID = F.ID "
			+ "LEFT JOIN SETOR S " + "ON A.SETOR_ID = S.ID " + "WHERE DATA_SAIDA = '3000-01-01 00:00:00	'",
			countQuery = "SELECT count(*) FROM SETOR_FUNCIONARIO")
	public Page<AlocacaoGeral> findAllTipo(Pageable pageable);
}
