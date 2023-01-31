package br.com.robson.qualitycontrol.models.enums;

import lombok.Getter;

@Getter
public enum SolvedNoticeStatus {
	
	RECEIVED(0, "Notificação recebida pelo chefe do setor"),
	STARTED(1, "Resolução de não conformidade foi iniciada pelo chefe do setor"),
	SENT(2, "Foi enviado uma proposta de resolução de não conformidade para o responsável pela qualidade "),
	REJECTED(3, "A proposta de resolução precisa ser revista"),
	APPROVED(4, "A proposta de resolução de não conformidade foi aceita pelo responsável pela qualidade"),
	RUNNING(5, "As açõres propostas nas resolução estão em andamento"),
	FINISHED(6, "Finalido o todas as ações que visão resolver o problema");	
	
	private int code;
	private String description;
	
	private SolvedNoticeStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static SolvedNoticeStatus toEnum(Integer code) {
		
		if (code == null) {
			return null;
		}
		
		for (SolvedNoticeStatus x : SolvedNoticeStatus.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + code);
	}
}
