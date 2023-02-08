package br.com.robson.qualitycontrol.services;

import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.robson.qualitycontrol.exceptions.ObjectNotFoundException;
import br.com.robson.qualitycontrol.models.FilePathEvidence;
import br.com.robson.qualitycontrol.models.notice.Notice;
import br.com.robson.qualitycontrol.repositories.FilePathEvidenceRepository;

@Service
public class FilesStorageFacade {

	@Autowired
	private FilesStorageServiceImpl filesStorageService;

	@Autowired
	private FilePathEvidenceRepository filePathEvidenceRepository;

	@Autowired
	private NoticeService noticeService;

	public void save(MultipartFile file, Long noticeId) {

		Optional<Notice> notice = noticeService.findByNoticeId(noticeId);

		notice.orElseThrow(
				() -> new ObjectNotFoundException("Notificação não encontrada na base para arquivo anexado! Id: "
						+ noticeId + ", Tipo: " + notice.getClass()));

		String completePathFile = filesStorageService.save(file, notice.get().getSectorNoticed().getAcronym(),
				noticeId.toString());

		filePathEvidenceRepository
				.save(FilePathEvidence.builder().notice(notice.get()).pathPhysicalFile(completePathFile).build());
	}

	public Resource load(Long noticeId, String fileName) {

		Optional<Notice> notice = noticeService.findByNoticeId(noticeId);

		notice.orElseThrow(() -> new ObjectNotFoundException("Arquivo: " + fileName
				+ "não foi encontrado para a notificação de ID:" + noticeId + ", Tipo: " + notice.getClass()));

		return filesStorageService.load(notice.get().getSectorNoticed().getAcronym(), noticeId.toString(), fileName);
	}

	public Stream<Path> loadAll(Long noticeId) {

		Optional<Notice> notice = noticeService.findByNoticeId(noticeId);

		notice.orElseThrow(() -> new ObjectNotFoundException(
				"Não encontrados arquivos para a notificação Id: " + noticeId + ", Tipo: " + notice.getClass()));

		return filesStorageService.loadAll(notice.get().getSectorNoticed().getAcronym(), noticeId.toString());
	}

	public boolean delete(Long noticeId, String fileName) {

		Optional<Notice> notice = noticeService.findByNoticeId(noticeId);

		notice.orElseThrow(() -> new ObjectNotFoundException("Arquivo: " + fileName
				+ "não foi encontrado para a notificação de ID:" + noticeId + ", Tipo: " + notice.getClass()));

		return filesStorageService.delete(notice.get().getSectorNoticed().getAcronym(), noticeId.toString(), fileName);
	}

}
