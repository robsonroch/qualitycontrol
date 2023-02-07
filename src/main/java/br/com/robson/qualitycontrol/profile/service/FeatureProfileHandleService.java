package br.com.robson.qualitycontrol.profile.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


@Service
public class FeatureProfileHandleService {
		
	public static MapPerfis getFeatureProfile() {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		
		mapper.findAndRegisterModules();
		
		MapPerfis featureProfile = null;
		
		try {
			featureProfile = mapper.readValue(new File("src/main/resources/feature-profile.yaml"), MapPerfis.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return featureProfile;
	}
}
