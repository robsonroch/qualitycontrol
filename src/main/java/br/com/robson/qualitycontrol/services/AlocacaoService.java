package br.com.robson.qualitycontrol.services;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.exceptions.DataIntegrityException;
import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.AlocacaoChefia;
import br.com.robson.qualitycontrol.models.AlocacaoFuncionario;
import br.com.robson.qualitycontrol.models.AlocacaoGeral;
import br.com.robson.qualitycontrol.models.AlocacaoPK;
import br.com.robson.qualitycontrol.models.AlocacaoQualidade;
import br.com.robson.qualitycontrol.models.Funcionario;
import br.com.robson.qualitycontrol.models.builders.ConvertToModel;
import br.com.robson.qualitycontrol.models.utils.TipoAlocacaoEnum;
import br.com.robson.qualitycontrol.repositories.AlocacaoRepository;
import br.com.robson.qualitycontrol.resources.requests.AlocacaoRequest;

@Service
public class AlocacaoService extends Servico<Alocacao, AlocacaoPK> {
	
	@Autowired
	private ConvertToModel<AlocacaoQualidade> builderQualidade;
	
	@Autowired
	private ConvertToModel<AlocacaoFuncionario> builderFuncionario;
	
	@Autowired
	private ConvertToModel<AlocacaoChefia> builderChefia;
	
	@Autowired
	private AlocacaoRepository alocRepo;
	
	private static final Date DATA_SAIDA_DEFAULT = new GregorianCalendar(3000, 1 - 1, 1).getTime();
	
	@Override
    public Alocacao insert(Object obj) {
		
		AlocacaoRequest alocRequest = (AlocacaoRequest) obj;
		
		try {
			if(alocRequest.getTipo().equals(TipoAlocacaoEnum.QUALIDADE.name())) {
				return alocRepo.save(builderQualidade.executa(obj));
			}
			if(alocRequest.getTipo().equals(TipoAlocacaoEnum.CHEFIA.name())){
				return alocRepo.save(builderChefia.executa(obj));
			}
			if(alocRequest.getTipo().equals(TipoAlocacaoEnum.FUNCIONARIO.name())){
				return alocRepo.save(builderFuncionario.executa(obj));
			}
		
			return null;
		}
		catch (DataIntegrityViolationException e) {
			if(e.getMessage().contains("ALOCACAO_UNICA")) {
				throw new DataIntegrityException("Funcionário deve ter alocação única!");				
			}
			if(e.getMessage().contains("CHEFIA_UNICA")) {
				throw new DataIntegrityException("Setor deve ter único chefe!");				
			}
			if(e.getMessage().contains("QA_UNICO")) {
				throw new DataIntegrityException("Setor deve ter apenas um QA!");				
			}
			
			throw new DataIntegrityException("Erro na alocação do funcionário!");
		}
		
	}
	
	public Alocacao findByCpfFuncionario(String cpf) {
		return  alocRepo.findByIdFuncionarioCpf(cpf);
	}
	
	public Alocacao findAtualLocacaoByCpf(String cpf, Long setorId) {
		return  alocRepo.findByIdFuncionarioCpfAndIdSetorIdAndDataSaida(cpf, setorId, AlocacaoService.DATA_SAIDA_DEFAULT);
	}
	
	public Alocacao desalocaFuncionario(String cpf) {
		Alocacao alocacaoFromBase = alocRepo.findByIdFuncionarioCpf(cpf);
		alocacaoFromBase.setDataSaida(new Date());
		
		return alocRepo.save(alocacaoFromBase);
	}
	
	public Page<AlocacaoGeral> findPageFull(String direction) {
		PageRequest pageRequest = PageRequest.of(1, 2, Direction.valueOf(direction), "tipoAlocacao");
		
		return alocRepo.findAllTipo(pageRequest);
	}
	
}
