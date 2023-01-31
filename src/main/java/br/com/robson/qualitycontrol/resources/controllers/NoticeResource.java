package br.com.robson.qualitycontrol.resources.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.Notice;
import br.com.robson.qualitycontrol.resources.requests.NoticeRequest;
import br.com.robson.qualitycontrol.services.NoticeService;

@RestController
@RequestMapping(value = "/notificacoes")
public class NoticeResource {
	
	@Autowired
	private NoticeService noticeSevice;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Notice> find(@PathVariable Long id) {
		Notice notice = noticeSevice.findById(id);		
				
		return ResponseEntity.ok().body(notice);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<@Valid NoticeRequest> insert(@Valid @RequestBody NoticeRequest noticeRequest) {
		
		Notice insert = noticeSevice.insert(noticeRequest);
		
		/*
		 * SlaNotice obj = service.insert(objDto); URI uri =
		 * ServletUriComponentsBuilder.fromCurrentRequest()
		 * .path("/{id}").buildAndExpand(obj.getId()).toUri();
		 */
		return ResponseEntity.ok().body(noticeRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PATCH)
	public ResponseEntity<@Valid NoticeRequest> attachFileEvidence(@Valid @RequestBody NoticeRequest noticeRequest) {
		
		/*
		 * SlaNotice obj = service.insert(objDto); URI uri =
		 * ServletUriComponentsBuilder.fromCurrentRequest()
		 * .path("/{id}").buildAndExpand(obj.getId()).toUri();
		 */
		return ResponseEntity.ok().body(noticeRequest);
	}

}
