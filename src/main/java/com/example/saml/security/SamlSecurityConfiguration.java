package com.example.saml.security;
import com.example.saml.saml.config.SamlAppConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.saml.provider.SamlServerConfiguration;
import org.springframework.security.saml.provider.service.config.SamlServiceProviderServerBeanConfiguration;

@Configuration
public class SamlSecurityConfiguration extends SamlServiceProviderServerBeanConfiguration {

	private final SamlAppConfig samlAppConfig;

	public SamlSecurityConfiguration(SamlAppConfig samlAppConfig){
		this.samlAppConfig = samlAppConfig;
	}

	@Override
	protected SamlServerConfiguration getDefaultHostSamlServerConfiguration() {
		return samlAppConfig;
	}

/*	private LocalServiceProviderConfiguration getLocalServiceProviderConfiguration() {
		final LocalServiceProviderConfiguration serviceProvider = new LocalServiceProviderConfiguration();

		serviceProvider.setSignRequests(false);
		serviceProvider.setWantAssertionsSigned(false);
		serviceProvider.setEntityId("https://localhost:8443/saml/metadata");
		serviceProvider.setSignMetadata(false);
		serviceProvider.setKeys(rotatingKeys());
		serviceProvider.setBasePath("/");
		List<Object> namedIds = new ArrayList<>();
		namedIds.add("urn:oasis:names:tc:SAML:2.0:nameid-format:persistent");
		namedIds.add("urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress");
		namedIds.add("urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified");
		serviceProvider.setNameIds(namedIds);
		List<ExternalIdentityProviderConfiguration> providers = new ArrayList<>();
		providers.add(externalProvider());
		serviceProvider.setProviders(providers);
		return serviceProvider;
	}

	private ExternalIdentityProviderConfiguration externalProvider() {
		final ExternalIdentityProviderConfiguration externalIdentityProviderConfiguration = new ExternalIdentityProviderConfiguration();
		externalIdentityProviderConfiguration.setMetadata("https://dev-673817.okta.com/app/exkqkkg0kUVEvNyg14x6/sso/saml/metadata");
		try{
			externalIdentityProviderConfiguration.setAuthenticationRequestBinding(new URI("urn:oasis:names:tc:SAML:2.0:bindings:HTTP-POST"));
		}catch(URISyntaxException e){
			e.printStackTrace();
		}
		externalIdentityProviderConfiguration.setSkipSslValidation(true);

		return externalIdentityProviderConfiguration;
	}

	private RotatingKeys rotatingKeys() {
		X509Certificate myCertificate = CertUtil.getCertificateByName("spring", "keystore.jks", "secret");
		final RotatingKeys rotatingKeys = new RotatingKeys();
		SimpleKey activeKey = new SimpleKey();
		activeKey.setName("spring");
		try {
			activeKey.setCertificate(getCertificateForKey(myCertificate));
		} catch (CertificateEncodingException e) {
			e.printStackTrace();
		}
		rotatingKeys.setActive(activeKey);
		return rotatingKeys;
	}

	private String getCertificateForKey(X509Certificate myCertificate) throws CertificateEncodingException {
		return getEncoder().encodeToString(myCertificate.getEncoded());
	}*/
}
