package br.com.robson.qualitycontrol.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Profile("test")
@EnableJpaRepositories(basePackages = "br.com.robson.qualitycontrol.repositories")
@EnableTransactionManagement
public class TestConfig {
	
}
