package br.com.robson.qualitycontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.models.SlaNotice;
import br.com.robson.qualitycontrol.models.enums.SlaEnum;
import br.com.robson.qualitycontrol.repositories.SlaNoticeRepository;

@Service
public class SlaNoticeService extends GenericService<SlaNotice, Long> {
	
	@Autowired
	private SlaNoticeRepository slaNoticeRepo;
	
	public SlaNotice findActualSlaNoticeByTypeSlaAndSetorId(Long setorId, Integer codeSla) {		
		return this.slaNoticeRepo.findBySectorIdAndTypeSla(setorId, SlaEnum.toEnum(codeSla));
	}

}
