package br.com.robson.qualitycontrol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
	
	public List<Notice> findAllBySectorNoticedId(Long sectorId);
	
	public List<Notice> findAllBySectorNoticedAcronym(String acronym);

}
