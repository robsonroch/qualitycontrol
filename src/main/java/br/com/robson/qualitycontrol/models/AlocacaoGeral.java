package br.com.robson.qualitycontrol.models;

import java.util.Date;

public interface AlocacaoGeral {
	
	String getTipoAlocacao();
	
	String getNomeSetor();
	
	String getNomeFuncionario();
	
	String getCpf();
	
	String getEmail();
	
	Date getDataEntrada();
	
	Date getDataSaida();

}
