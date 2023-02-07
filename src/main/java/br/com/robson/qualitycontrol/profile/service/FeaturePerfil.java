package br.com.robson.qualitycontrol.profile.service;

import java.util.HashSet;
import java.util.Set;

import br.com.robson.qualitycontrol.models.enums.ActionFeature;
import lombok.Data;

@Data
public class FeaturePerfil  {
	private String featureUrl;
    private Boolean ativo;
    private Set<ActionFeature> actionFatures = new HashSet<ActionFeature>();		
}
