package br.com.robson.qualitycontrol.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
	
	Optional<Sector> findByAcronym(String acronym);
	
}
