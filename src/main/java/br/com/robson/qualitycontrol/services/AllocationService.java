package br.com.robson.qualitycontrol.services;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.exceptions.DataIntegrityException;
import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.AllocationBoss;
import br.com.robson.qualitycontrol.models.AllocationEmployee;
import br.com.robson.qualitycontrol.models.AllocationGeneric;
import br.com.robson.qualitycontrol.models.AllocationPK;
import br.com.robson.qualitycontrol.models.AllocationQuality;
import br.com.robson.qualitycontrol.models.converters.ConvertToModel;
import br.com.robson.qualitycontrol.models.utils.AllocationTypeEnum;
import br.com.robson.qualitycontrol.repositories.AllocationRepository;
import br.com.robson.qualitycontrol.resources.requests.AllocationRequest;

@Service
public class AllocationService extends GenericService<Allocation, AllocationPK> {
	
	@Autowired
	private ConvertToModel<AllocationQuality> builderQualidade;
	
	@Autowired
	private ConvertToModel<AllocationEmployee> builderFuncionario;
	
	@Autowired
	private ConvertToModel<AllocationBoss> builderChefia;
	
	@Autowired
	private AllocationRepository alocRepo;
	
	private static final Date END_DATE_DEFAULT = new GregorianCalendar(3000, 1 - 1, 1).getTime();
	
	@Override
    public Allocation insert(Object obj) {
		
		AllocationRequest alocRequest = (AllocationRequest) obj;
		
		try {
			if(alocRequest.getType().equals(AllocationTypeEnum.QUALITY.name())) {
				return alocRepo.save(builderQualidade.executa(obj));
			}
			if(alocRequest.getType().equals(AllocationTypeEnum.BOSS.name())){
				return alocRepo.save(builderChefia.executa(obj));
			}
			if(alocRequest.getType().equals(AllocationTypeEnum.EMPLOYEE.name())){
				return alocRepo.save(builderFuncionario.executa(obj));
			}
		
			return null;
		}
		catch (DataIntegrityViolationException e) {
			if(e.getMessage().contains("EMPLOYEE_UNIQUE_ALLOCATION")) {
				throw new DataIntegrityException("Funcionário deve ter alocação única!");				
			}
			if(e.getMessage().contains("BOSS_ONLY_ONE")) {
				throw new DataIntegrityException("Setor deve ter único chefe!");				
			}
			if(e.getMessage().contains("QA_ONLY_ONE")) {
				throw new DataIntegrityException("Setor deve ter apenas um QA!");				
			}
			
			throw new DataIntegrityException("Erro na alocação do funcionário!");
		}
		
	}
	
	public Allocation findByCpfFuncionario(String cpf) {
		return  alocRepo.findByIdEmployeeCpf(cpf);
	}
	
	public Allocation findAtualLocacaoByCpf(String cpf, Long setorId) {
		return  alocRepo.findByIdEmployeeCpfAndIdSectorIdAndEndAllocationDate(cpf, setorId, AllocationService.END_DATE_DEFAULT);
	}
	
	public Allocation desalocaFuncionario(String cpf) {
		Allocation alocacaoFromBase = alocRepo.findByIdEmployeeCpf(cpf);
		alocacaoFromBase.setEndAllocationDate(new Date());
		
		return alocRepo.save(alocacaoFromBase);
	}
	
	public Page<AllocationGeneric> findPageFull(Integer pagina, Integer linhaPorPagina, String ordeBy, String direction) {
		PageRequest pageRequest = PageRequest.of(pagina, linhaPorPagina, Direction.valueOf(direction), ordeBy);
		Page<AllocationGeneric> findAllType = alocRepo.findAllType(pageRequest);
		return findAllType;
	}
	
	
}
