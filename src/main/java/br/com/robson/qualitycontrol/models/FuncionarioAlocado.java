package br.com.robson.qualitycontrol.models;

@FunctionalInterface
public interface FuncionarioAlocado {
	
	public Employee getFuncionario(Allocation alocacao);

}
