package com.example.saml.security;

import static org.springframework.security.saml.provider.service.config.SamlServiceProviderSecurityDsl.serviceProvider;

import com.example.saml.saml.config.SamlAppConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.saml.provider.service.config.SamlServiceProviderSecurityConfiguration;
import org.springframework.security.saml.provider.service.config.SamlServiceProviderServerBeanConfiguration;

@EnableWebSecurity
@Configuration
@Order(1)
public class SamlWebSecurityConfiguration extends SamlServiceProviderSecurityConfiguration {

	private SamlAppConfig samlAppConfig;

	public SamlWebSecurityConfiguration(
			SamlServiceProviderServerBeanConfiguration configuration, @Qualifier("samlAppConfig") SamlAppConfig samlAppConfig) {
		super("/saml/sp/",configuration);
		this.samlAppConfig = samlAppConfig;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.apply(serviceProvider()).configure(samlAppConfig);
	}
}
