package br.com.robson.qualitycontrol.models.notice.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.SlaNotice;
import br.com.robson.qualitycontrol.models.converters.ConvertToModel;
import br.com.robson.qualitycontrol.models.enums.SlaEnum;
import br.com.robson.qualitycontrol.models.notice.request.SlaNoticeRequest;
import br.com.robson.qualitycontrol.repositories.EmployeeRepository;
import br.com.robson.qualitycontrol.repositories.SectorRepository;

@Component
public class RequestToSlaNotice implements ConvertToModel<SlaNotice>{
	
	@Autowired
	private EmployeeRepository employeeRepo;
	@Autowired
	private SectorRepository sectorRepo;

	@Override
	public SlaNotice executa(Object origin) {
		
		SlaNoticeRequest sr = (SlaNoticeRequest) origin;
		
		return SlaNotice.builder()
				.sector(sectorRepo.getOne(sr.getSectorId()))
				.slaTimeStamp(sr.getSlaTimeStamp())
				.typeSla(SlaEnum.toEnum(sr.getTypeSla()))
				.build();
		
	}
	
}
