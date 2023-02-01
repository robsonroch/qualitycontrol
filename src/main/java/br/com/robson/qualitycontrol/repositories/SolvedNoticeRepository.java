package br.com.robson.qualitycontrol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.Notice;
import br.com.robson.qualitycontrol.models.SolvedNotice;

@Repository
public interface SolvedNoticeRepository extends JpaRepository<SolvedNotice, Long> {
	
	public List<SolvedNotice> findByNoticeId(Long NoticeId);
	
}
