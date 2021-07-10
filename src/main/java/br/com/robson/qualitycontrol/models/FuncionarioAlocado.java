package br.com.robson.qualitycontrol.models;

@FunctionalInterface
public interface FuncionarioAlocado {
	
	public Funcionario getFuncionario(Alocacao alocacao);

}
