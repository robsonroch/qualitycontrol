package br.com.robson.qualitycontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robson.qualitycontrol.models.FilePathEvidence;

public interface FilePathEvidenceRepository extends JpaRepository<FilePathEvidence, Long> {
	
}
