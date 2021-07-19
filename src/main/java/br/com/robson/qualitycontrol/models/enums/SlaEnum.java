package br.com.robson.qualitycontrol.models.enums;

import lombok.Getter;

@Getter
public enum SlaEnum {
	
	NO_URGENT(0, "Pode esperar"),
	LITTLE_URGENT(1, "Pouco urgente"),
	URGENT(2, "Urgente, merece atenção no curto prazo"),
	VERY_URGENT(3, "Muito urgente"),
	STRONG_URGENT(4, "Necessidade de ação imetiata");
	
	private int code;
	private String description;
	
	private SlaEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static SlaEnum toEnum(Integer code) {
		
		if (code == null) {
			return null;
		}
		
		for (SlaEnum x : SlaEnum.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + code);
	}
}
