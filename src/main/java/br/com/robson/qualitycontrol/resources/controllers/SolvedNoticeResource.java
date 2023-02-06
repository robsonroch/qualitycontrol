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
import br.com.robson.qualitycontrol.models.SolvedNotice;
import br.com.robson.qualitycontrol.models.notice.request.NoticeRequest;
import br.com.robson.qualitycontrol.models.notice.request.SolvedNoticeRequest;
import br.com.robson.qualitycontrol.resources.services.SolvedNoticeFacade;
import br.com.robson.qualitycontrol.services.NoticeService;

@RestController
@RequestMapping(value = "/resolucoes")
public class SolvedNoticeResource {
	
	@Autowired
	private SolvedNoticeFacade solvedNoticeFacade;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {		
				
		return ResponseEntity.ok().body(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody SolvedNoticeRequest SolvedNoticeRequest) {
		
		return ResponseEntity.ok().body(null);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PATCH)
	public ResponseEntity<?> attachFileEvidence(@Valid @RequestBody NoticeRequest noticeRequest) {

		return ResponseEntity.ok().body(noticeRequest);
	}

}
