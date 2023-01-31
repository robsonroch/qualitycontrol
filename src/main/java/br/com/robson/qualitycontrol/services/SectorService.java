package br.com.robson.qualitycontrol.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.exceptions.ObjectNotFoundException;
import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.repositories.SectorRepository;

@Service
public class SectorService extends GenericService<Sector, Long> {
	
	@Autowired
	private SectorRepository sectorRepository;
	
	public Sector getSectorByAcronym(String acronym) {
		Optional<Sector> sector = sectorRepository.findByAcronym(acronym);
		
		return sector.orElseThrow(() -> new ObjectNotFoundException(
				"Setor não encontrado para a sigla: " + acronym));
	}
	
}
