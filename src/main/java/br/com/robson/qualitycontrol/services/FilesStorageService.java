package br.com.robson.qualitycontrol.services;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {

	String save(MultipartFile file, String directory);

	Resource load(String filename);

	boolean delete(String filename);

	void deleteAll();

	Stream<Path> loadAll(String directory);

}
