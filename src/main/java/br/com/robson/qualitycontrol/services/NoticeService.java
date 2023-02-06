package br.com.robson.qualitycontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.models.Notice;
import br.com.robson.qualitycontrol.models.notice.converters.NoticeToNoticeObserverResponse;
import br.com.robson.qualitycontrol.models.notice.response.NoticeObserverResponse;
import br.com.robson.qualitycontrol.repositories.NoticeRepository;
import br.com.robson.qualitycontrol.security.jwt.UserSS;
import br.com.robson.qualitycontrol.services.exception.AuthorizationException;

@Service
public class NoticeService extends GenericService<Notice, Long> {
	
	@Autowired
	private NoticeRepository noticeRepo;
	
	@Autowired
	private NoticeToNoticeObserverResponse noticeToNoticeObserverResponse;
	
	public List<NoticeObserverResponse> findAllByObserverId(Long observerId) {
		
		UserSS user = UserService.authenticated();
		
		if(!user.getId().equals(observerId)) {
			throw new AuthorizationException("Acesso negado");
		}
		List<Notice> fromBase = this.noticeRepo.findAllByObserverId(observerId);
		List<NoticeObserverResponse> response = fromBase.stream().map(n -> noticeToNoticeObserverResponse.executa(n)).collect(Collectors.toList());
		
		return  response;
			
	}
			
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
