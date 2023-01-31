package br.com.robson.qualitycontrol.resources.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import br.com.robson.qualitycontrol.resources.response.FileResponse;
import br.com.robson.qualitycontrol.resources.response.MessageResponse;
import br.com.robson.qualitycontrol.services.FilesStorageFacade;
import br.com.robson.qualitycontrol.services.FilesStorageServiceImpl;

@Controller
@RequestMapping(value = "/files")
@CrossOrigin("http://localhost:8888")
public class FilesResource {

  @Autowired
  private FilesStorageFacade filesStorageFacade;

  @PostMapping("/{noticeId}")
  public ResponseEntity<MessageResponse> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("noticeId") Long noticeId) {
    String message = "";
    try {
    	filesStorageFacade.save(file, noticeId);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    }
  }

  @GetMapping("/{noticeId}")
  public ResponseEntity<List<FileResponse>> getListFiles(@PathVariable Long noticeId) {
    List<FileResponse> fileInfos = filesStorageFacade.loadAll(noticeId).map(path -> {
      String filename = path.getFileName().toString();
      String url = MvcUriComponentsBuilder
          .fromMethodName(FilesResource.class, "getFile", noticeId, path.getFileName().toString()).build().toString();

      return new FileResponse(filename, url);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
  }

  @GetMapping("/{noticeId}/{fileName}")
  public ResponseEntity<Resource> getFile(@PathVariable Long noticeId, @PathVariable String fileName) {
    Resource file = filesStorageFacade.load(noticeId, fileName);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }

  @DeleteMapping("/{noticeId}/{fileName}")
  public ResponseEntity<MessageResponse> deleteFile(@PathVariable String acronym, @PathVariable Long noticeId, @PathVariable String fileName) {
    String message = "";
    
    try {
      boolean existed = filesStorageFacade.delete(noticeId, fileName);
      
      if (existed) {
        message = "Delete the file successfully: " + fileName;
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
      }
      
      message = "The file does not exist!";
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse(message));
    } catch (Exception e) {
      message = "Could not delete the file: " + fileName + ". Error: " + e.getMessage();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse(message));
    }
  }
}
