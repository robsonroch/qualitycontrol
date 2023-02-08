package br.com.robson.qualitycontrol.models.enums;

import lombok.Getter;

@Getter
public enum NonConformingType {
	
	HUMAN_NON_CONFORMITY(0, "Erro humano atendimento ou no procedimento"),
	PROCESS_NON_CONFORMING(1, "Erro de processo no atendimento ou no procedimento"),
	TECHNICAL_NON_CONFORMING(2, "Erro técnico no atendimento ou no procedimento"),
	IS_NOT_INCONFORMING(3, "O fato relatado não é inconformidade"),
	NOT_RATED(3, "A notificação ainda não classificada");	
	
	private int code;
	private String description;
	
	private NonConformingType(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static NonConformingType toEnum(Integer code) {
		
		if (code == null) {
			return null;
		}
		
		for (NonConformingType x : NonConformingType.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + code);
	}
}
