package br.com.robson.qualitycontrol.models.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.AllocationBoss;
import br.com.robson.qualitycontrol.models.AlocacaoFuncionario;
import br.com.robson.qualitycontrol.models.AlocacaoQualidade;
import br.com.robson.qualitycontrol.models.builders.ConvertToModel;
import lombok.Getter;

public enum TipoAlocacaoEnum {
	
	QUALIDADE(),
	CHEFIA(),
	FUNCIONARIO();
	
}
