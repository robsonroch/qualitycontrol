package br.com.robson.qualitycontrol.resources.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.robson.qualitycontrol.models.notice.Notice;
import br.com.robson.qualitycontrol.models.notice.converters.NoticeToNoticeResponse;
import br.com.robson.qualitycontrol.models.notice.request.NoticeRequest;
import br.com.robson.qualitycontrol.models.notice.response.NoticeResponse;
import br.com.robson.qualitycontrol.resources.response.SectorResponse;
import br.com.robson.qualitycontrol.services.NoticeService;

@RestController
@RequestMapping(value = "/notificacoes")
public class NoticeResource {
	
	@Autowired
	private NoticeService noticeSevice;
	
	@Autowired
	private NoticeToNoticeResponse builderResponse;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<NoticeResponse> find(@PathVariable Long id) {
		Notice notice = noticeSevice.findById(id);		
				
		return ResponseEntity.ok().body(builderResponse.executa(notice));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<NoticeResponse>> findAll() {
		List<Notice> list = noticeSevice.findAll();
		List<NoticeResponse> listDto = list.stream().map(obj -> builderResponse.executa(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<NoticeRequest> insert(@Valid @RequestBody NoticeRequest noticeRequest) {
		
		Notice insert = noticeSevice.insert(noticeRequest);
		
		/*
		 * SlaNotice obj = service.insert(objDto); URI uri =
		 * ServletUriComponentsBuilder.fromCurrentRequest()
		 * .path("/{id}").buildAndExpand(obj.getId()).toUri();
		 */
		return ResponseEntity.ok().body(noticeRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PATCH)
	public ResponseEntity<br.com.robson.qualitycontrol.models.notice.request.NoticeRequest> attachFileEvidence(@Valid @RequestBody NoticeRequest noticeRequest) {
		
		/*
		 * SlaNotice obj = service.insert(objDto); URI uri =
		 * ServletUriComponentsBuilder.fromCurrentRequest()
		 * .path("/{id}").buildAndExpand(obj.getId()).toUri();
		 */
		return ResponseEntity.ok().body(noticeRequest);
	}

}
