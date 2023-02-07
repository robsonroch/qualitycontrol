package br.com.robson.qualitycontrol.models.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Perfil {
	
	ADMIN(0, "ROLE_ADMIN"),
	QUALITY(1, "ROLE_QUALITY"),
	BOSS(2, "ROLE_BOSS"),
	OBSERVER(3, "ROLE_OBSERVER"),
	EMPLOYEE(4, "ROLE_EMPLOYEE");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
