package br.com.robson.qualitycontrol.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.robson.qualitycontrol.repositories.FilePathEvidenceRepository;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {
	
	private final Path root = Paths.get("uploads");

	public String save(MultipartFile file, String acronym, String noticeId) {
				
		return this.save(file, getPathFromListPathPieces(acronym, noticeId));
	}
	
	public Resource load(String acronym, String noticeId, String fileName) {
		return this.load(getPathFromListPathPieces(acronym, noticeId, fileName));
	}
	
	public Stream<Path> loadAll(String acronym, String noticeId) {
		return this.loadAll(getPathFromListPathPieces(acronym, noticeId));
	}
	
	public boolean delete(String acronym, String noticeId, String fileName) {
		return this.delete(getPathFromListPathPieces(acronym, noticeId, fileName));
	}


	private String getPathFromListPathPieces(String...pathPieces) {
		
		StringBuilder stringBuilder = new StringBuilder("uploads");

		for(String pathPieace : pathPieces) {
			stringBuilder.append("/");
			stringBuilder.append(pathPieace);			
		}
		
		return stringBuilder.toString();
	}

	@Override
	public String save(MultipartFile file, String subdirectory) {
		
		Path completePathFile = null;
		
		try {
			File directory = new File(subdirectory);
			if (!directory.exists()) {
				Files.createDirectories(Paths.get(subdirectory));
			}					
			
			completePathFile = Paths.get(subdirectory).resolve(file.getOriginalFilename());
			
			Files.copy(file.getInputStream(), completePathFile);
		} catch (Exception e) {
			if (e instanceof FileAlreadyExistsException) {
				throw new RuntimeException("A file of that name already exists.");
			}

			throw new RuntimeException(e.getMessage());
		}
		
		return  completePathFile.getParent().toString()
				.concat("/")
				.concat(completePathFile.getFileName().toString());
	}

	@Override
	public Resource load(String pathFileName) {
		try {
			Path file = Paths.get(pathFileName);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	@Override
	public boolean delete(String filename) {
		try {
			Path file = Paths.get(filename);
			return Files.deleteIfExists(file);
		} catch (IOException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());
	}

	@Override
	public Stream<Path> loadAll(String directory) {
		try {
			Path directoryFrom = Paths.get(directory);
			
			return Files.walk(directoryFrom, 1).filter(path -> !path.equals(directoryFrom)).map(directoryFrom::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files!");
		}
	}

}
