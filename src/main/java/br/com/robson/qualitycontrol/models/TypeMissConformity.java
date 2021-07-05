package br.com.robson.qualitycontrol.models;

import lombok.Getter;

@Getter
public enum TypeMissConformity {

	TECNICO(0),
	HUMANO(1),
	PROCESSO(2);
	
	private Integer codigo;
	
	private TypeMissConformity(int codigo) {
		this.codigo = codigo;
		
	}
	
	
}
