package com.awpl.rest;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/api/bpmprocess/")
class ProposalController
{
	@Value("${bpm.username}")
	private String bpmUsername = "admin";
	@Value("${bpm.password}")
	private String bpmPassword = "admin";
	
	/**
	 * @return the bpmUsername
	 */
	public String getBpmUsername()
	{
		return bpmUsername;
	}

	/**
	 * @param bpmUsername the bpmUsername to set
	 */
	public void setBpmUsername(String bpmUsername)
	{
		this.bpmUsername = bpmUsername;
	}

	/**
	 * @return the bpmPassword
	 */
	public String getBpmPassword()
	{
		return bpmPassword;
	}

	/**
	 * @param bpmPassword the bpmPassword to set
	 */
	public void setBpmPassword(String bpmPassword)
	{
		this.bpmPassword = bpmPassword;
	}

	@Value("${bpm.restapi.startprocessurl}")
	private String bpmRestAPIStartProcessURL;

	/**
	 * @return the bpmRestAPIStartProcessURL
	 */
	public String getBpmRestAPIStartProcessURL()
	{
		return bpmRestAPIStartProcessURL;
	}

	/**
	 * @param bpmRestAPIStartProcessURL
	 *            the bpmRestAPIStartProcessURL to set
	 */
	public void setBpmRestAPIStartProcessURL(String bpmRestAPIURL)
	{
		this.bpmRestAPIStartProcessURL = bpmRestAPIURL;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/")
	public String startProcess(@RequestBody String processInputJson)
	{
		MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<String, String>();
		bodyMap.add("params", processInputJson);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		 String auth = bpmUsername + ":" + bpmPassword;
         byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")) );
         String authHeader = "Basic " + new String( encodedAuth );
         headers.add( "Authorization", authHeader );
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(bodyMap, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> model = restTemplate.exchange(bpmRestAPIStartProcessURL, HttpMethod.POST, request, String.class);
		String response = model.getBody();
		return response;
	}
}