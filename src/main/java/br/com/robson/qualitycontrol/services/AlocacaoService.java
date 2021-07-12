package br.com.robson.qualitycontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.robson.qualitycontrol.exceptions.DataIntegrityException;
import br.com.robson.qualitycontrol.models.Alocacao;
import br.com.robson.qualitycontrol.models.AlocacaoChefia;
import br.com.robson.qualitycontrol.models.AlocacaoFuncionario;
import br.com.robson.qualitycontrol.models.AlocacaoPK;
import br.com.robson.qualitycontrol.models.AlocacaoQualidade;
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
	
	@Override
    public Alocacao insert(Object obj) {
		
		AlocacaoRequest alocRequest = (AlocacaoRequest) obj;
		
		try {
			if(alocRequest.getTipo().equals(TipoAlocacaoEnum.QUALIDADE.name())) {
				return repo.save(builderQualidade.executa(obj));
			}
			if(alocRequest.getTipo().equals(TipoAlocacaoEnum.CHEFIA.name())){
				return repo.save(builderChefia.executa(obj));
			}
			if(alocRequest.getTipo().equals(TipoAlocacaoEnum.FUNCIONARIO.name())){
				return repo.save(builderFuncionario.executa(obj));
			}
		
			return null;
		}
		catch (DataIntegrityViolationException e) {
			if(e.getMessage().contains("ALOCACAO_UNICA")) {
				throw new DataIntegrityException("Funcionário deve ter alocação única!");				
			}
			
			throw new DataIntegrityException("Erro na alocação do funcionário!");
		}
		
	}
	
	public Alocacao findByEmail(String email) {
		return this.alocRepo.findByAlocacaoPKFuncionarioEmailEqual(email);
	}

}
