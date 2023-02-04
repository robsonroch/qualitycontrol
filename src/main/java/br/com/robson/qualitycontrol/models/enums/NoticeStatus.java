package br.com.robson.qualitycontrol.models.enums;

import lombok.Getter;

@Getter
public enum NoticeStatus {
	
	RECEIVED(0, "Notificação será analisada em breve!"),
	CONFORMING_RATED(1, "Notifiação foi classificada e não há inconformidade!"),
	INCONFORMING_RATED(1, "Foi encontrada informidade na notificação!"),
	SECTOR_NOTICED(1, "Foi encontrada informidade na notificação!"),
	STARTED(1, "Resolução de não conformidade foi iniciada pelo chefe do setor"),
	SENT(2, "Foi enviado uma proposta de resolução de não conformidade para o responsável pela qualidade "),
	SOLVE_REJECTED(3, "A proposta de resolução precisa ser revista"),
	SOLVE_APPROVED(4, "A proposta de resolução de não conformidade foi aceita pelo responsável pela qualidade"),
	FINISHED(6, "Finalido o todas as ações que visão resolver o problema");	
	
	private int code;
	private String description;
	
	private NoticeStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static NoticeStatus toEnum(Integer code) {
		
		if (code == null) {
			return null;
		}
		
		for (NoticeStatus x : NoticeStatus.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + code);
	}
}
