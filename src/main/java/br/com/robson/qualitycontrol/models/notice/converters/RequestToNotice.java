package br.com.robson.qualitycontrol.models.notice.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.converters.ConvertToModel;
import br.com.robson.qualitycontrol.models.enums.NonConformingType;
import br.com.robson.qualitycontrol.models.notice.Notice;
import br.com.robson.qualitycontrol.models.notice.request.NoticeRequest;
import br.com.robson.qualitycontrol.services.SectorService;

@Component
public class RequestToNotice implements ConvertToModel<Notice>{
	
	@Autowired
	private SectorService sectorService;

	@Override
	public Notice executa(Object origin) {
		
		NoticeRequest request = (NoticeRequest) origin;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		df.setLenient (false); 
		Date parseDate = null;
		
		try {
			parseDate = df.parse("31/12/2006");
				
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Notice build = Notice.builder()
				.title(request.getTitle())
				.description(request.getDescription())
				.observationDate(parseDate)
				.nonConformingType(NonConformingType.NOT_RATED)
				.sectorNoticed(sectorService.findById(request.getSectorId()))
				.build();
		
		return build;
		
	}
	
}
