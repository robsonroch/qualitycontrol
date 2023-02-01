package br.com.robson.qualitycontrol.models.enums;

import lombok.Getter;

@Getter
public enum TypeAssessmentAction {
	
	NOT_ASSESSED(0, "A ação não foi avaliada"),
	DEFINING(1, "A ação está em trabalho de definição pelo chefe do setor"),
	APROVED(2, "A ação tem utilidade na resolução do problema"),
	DISCARDED(3, "A ação não ajuda na resolução do problema"),
	NEED_REDEFINED(4, "A ação precisa ser reajustada"),
	EXECUTED(5, "A ação foi realizada");
	
	private int code;
	private String description;
	
	private TypeAssessmentAction(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static TypeAssessmentAction toEnum(Integer code) {
		
		if (code == null) {
			return null;
		}
		
		for (TypeAssessmentAction x : TypeAssessmentAction.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + code);
	}
}
