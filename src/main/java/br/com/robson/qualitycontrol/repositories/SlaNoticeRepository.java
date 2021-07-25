package br.com.robson.qualitycontrol.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.SlaNotice;
import br.com.robson.qualitycontrol.models.enums.SlaEnum;

@Repository
public interface SlaNoticeRepository extends JpaRepository<SlaNotice, Long> {
	
	public SlaNotice findBySectorIdAndTypeSlaAndEndValidaty(Long setorId, SlaEnum typeSla, Date endValidaty);
	
}
