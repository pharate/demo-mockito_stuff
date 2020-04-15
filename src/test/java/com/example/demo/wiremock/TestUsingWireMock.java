package com.example.demo.wiremock;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Project;
import com.example.demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
//import com.github.tomakehurst.wiremock.http.HttpHeaders;
//import static org.springframework.http.HttpHeaders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 8080)
public class TestUsingWireMock {
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void testWireMock() throws JsonProcessingException {

		List<Project> projectList = new ArrayList<Project>();
		projectList.add(new Project("p1", null, "firstProject"));
		projectList.add(new Project("p4", null, "fourthProject"));
		projectList.add(new Project("p4", null, "fifthProject"));
		User user = new User("abhishek", 101, projectList);

		String myUser = this.mapper.writeValueAsString(user);

		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/testWireMockRest"))
				.willReturn(WireMock.aResponse().withBody(myUser).withStatus(200).withHeader(HttpHeaders.CONTENT_TYPE,
						org.springframework.http.MediaType.APPLICATION_JSON_VALUE)));

		// @Autowired
		RestTemplate template = new RestTemplate();

		String resultFromWireMock = template.getForEntity("http://localhost:8080/testWireMockRest", String.class)
				.getBody();
		System.out.println("response from wiremock:" + resultFromWireMock);
		assertTrue(true);// this is just for my understanding, not the correct way

	}
}
