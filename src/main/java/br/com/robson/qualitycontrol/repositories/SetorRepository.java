package br.com.robson.qualitycontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.Sector;

@Repository
public interface SetorRepository extends JpaRepository<Sector, Long> {
	
	@Query("SELECT s FROM Setor s JOIN s.funcionariosAlocados alocacao WHERE s.id =:setorId AND alocacao.tipoQA = true")
	public Sector procuraAlocacaoPeloTipo(@Param("setorId") Long setorId);

}
