package br.com.robson.qualitycontrol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.models.Notice;
import br.com.robson.qualitycontrol.repositories.NoticeRepository;

@Service
public class NoticeService extends GenericService<Notice, Long> {
	
	@Autowired
	private NoticeRepository noticeRepo;
	
	public List<Notice> findAllBySectorAcronym(String acronym) {
		return this.noticeRepo.findAllBySectorNoticedAcronym(acronym);
	}
	
	public List<Notice> findBySectorId(Long sectorId) {
		return this.noticeRepo.findAllBySectorNoticedId(sectorId);
	}
	
	public Optional<Notice> findByNoticeId(Long noticeId) {
		return this.noticeRepo.findById(noticeId);
	}

}
