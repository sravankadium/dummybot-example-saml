package com.example.saml.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.saml.provider.provisioning.SamlProviderProvisioning;
import org.springframework.security.saml.provider.service.ServiceProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

	private SamlProviderProvisioning<ServiceProviderService> provisioning;

	@Value("${saml.discovery.url:/saml/sp/discovery}")
	private String samlDiscoveryUrl;

	@Value("${saml.discovery.entity-id:https://sts.windows.net/c5ca272d-4a1f-4a91-bc8d-0612fc364138/}")
	private String samlDiscoveryEntityId;

	@Autowired
	public void setSamlService(SamlProviderProvisioning<ServiceProviderService> provisioning) {
		this.provisioning = provisioning;
	}

	@RequestMapping(value = {"/home"})
	public String home(Model model) {

		model.addAttribute("samlLink", "0; url='"+ samlDiscoveryUrl + "?idp="+ samlDiscoveryEntityId+"'");
		return "saml-login";
	}
	@RequestMapping(value = {"/"})
	public String home(){
		return "index";
	}


	@RequestMapping(value = {"/main"})
	public String main(){
		return "main";
	}

	@RequestMapping(value = {"/index", "/logged-in"})
	public String index() {
		return "logged-in";
	}

}
