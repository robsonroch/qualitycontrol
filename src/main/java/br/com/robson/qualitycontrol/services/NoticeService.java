package br.com.robson.qualitycontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.exceptions.DataIntegrityException;
import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.User;
import br.com.robson.qualitycontrol.models.notice.Notice;
import br.com.robson.qualitycontrol.models.notice.converters.NoticeToNoticeResponse;
import br.com.robson.qualitycontrol.models.notice.request.NoticeRequest;
import br.com.robson.qualitycontrol.models.notice.response.NoticeResponse;
import br.com.robson.qualitycontrol.models.utils.AllocationTypeEnum;
import br.com.robson.qualitycontrol.repositories.NoticeRepository;
import br.com.robson.qualitycontrol.repositories.UserRepository;
import br.com.robson.qualitycontrol.security.jwt.UserSS;
import br.com.robson.qualitycontrol.services.exception.AuthorizationException;

@Service
public class NoticeService extends GenericService<Notice, Long> {
	
	@Autowired
	private NoticeRepository noticeRepo;
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private AllocationService allocService;
	
	@Autowired
	private NoticeToNoticeResponse noticeToNoticeObserverResponse;
	
	public List<NoticeResponse> findAllByObserverId(Long observerId) {
		
		UserSS user = UserService.authenticated();
		
		if(!user.getId().equals(observerId)) {
			throw new AuthorizationException("Acesso negado");
		}
		List<Notice> fromBase = this.noticeRepo.findAllByObserverId(observerId);
		List<NoticeResponse> response = fromBase.stream().map(n -> noticeToNoticeObserverResponse.executa(n)).collect(Collectors.toList());
		
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
	
	@Override
	public Notice insert(Object obj) {
				
		try {
			Notice newNotice = builderModel.executa(obj);
			
			UserSS user = UserService.authenticated();
			
			if(user == null) {
				throw new AuthorizationException("Acesso negado");
			}
			
			Optional<Allocation> qualityOfSector = allocService.findBySectorAndTypeAllocation(newNotice.getSectorNoticed().getId(), AllocationTypeEnum.QUALITY);
			
			if(qualityOfSector.isPresent()) {
				newNotice.setQualityAssuranceOrigin(qualityOfSector.get().getEmployee());
			}
			
			User observer = userRepository.findByEmail(user.getUsername());
			newNotice.setObserver(observer);

			return repo.save(newNotice);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Verifique o CPF/Email já em uso!");
		}
		
	}
	
}
