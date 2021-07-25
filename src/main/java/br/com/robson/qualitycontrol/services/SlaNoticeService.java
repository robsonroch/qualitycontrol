package br.com.robson.qualitycontrol.services;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.models.Sector;
import br.com.robson.qualitycontrol.models.SlaNotice;
import br.com.robson.qualitycontrol.models.enums.SlaEnum;
import br.com.robson.qualitycontrol.repositories.SlaNoticeRepository;

@Service
public class SlaNoticeService extends Servico<SlaNotice, Long> {
	
	@Autowired
	private SlaNoticeRepository SlaNoticeRepo;
	
	public SlaNotice findActualSlaNoticeByTypeSlaAndSetorId(Long setorId, Integer codeSla) {		
		return this.SlaNoticeRepo.findBySectorIdAndTypeSlaAndEndValidaty(setorId, SlaEnum.toEnum(codeSla), new GregorianCalendar(3000, 1 - 1, 1).getTime());
	}

}
