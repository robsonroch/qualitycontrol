package br.com.robson.qualitycontrol.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum ActionFeature {

	CREATE(0, "Criar"), READ(1, "Ler"), UPDATE(2, "Alterar"), DELETE(3, "Excluir"), RATE(4, "Classificar"),
	SOLVED(4, "Resolver"), ASSESSMENT(5, "Avaliar");

	private Integer cod;
	private String descricao;

	private ActionFeature(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	@JsonValue
	public String getDescricao() {
		return descricao;
	}

	public static ActionFeature toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (ActionFeature x : ActionFeature.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

	@JsonCreator
	public static ActionFeature findValue(String name) {
		return Arrays.stream(ActionFeature.values()).filter(pt -> pt.name().equals(name)).findFirst().get();
	}

}
