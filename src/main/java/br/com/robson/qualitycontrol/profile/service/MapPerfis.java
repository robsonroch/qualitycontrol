package br.com.robson.qualitycontrol.profile.service;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class MapPerfis {
	private Map<String, Map<String, FeaturePerfil>> perfis = new HashMap<>();
		
}
