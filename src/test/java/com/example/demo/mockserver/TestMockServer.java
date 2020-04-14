package com.example.demo.mockserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class TestMockServer {
	private static ClientAndServer mockserver;

	@BeforeClass
	public static void startServer() {
		//mockserver = ClientAndServer.startClientAndServer(1080);
	}

	@AfterClass
	public static void stopServer() {
		//mockserver.stop();
	}

	@Test
	public void sampleTest() {
		mockserver = ClientAndServer.startClientAndServer(1080);
		String expectedResult = "xyz123";
		mockserver.when(HttpRequest.request().withPath("/testRest"))
				.respond(HttpResponse.response().withBody("xyz123"));
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> actualResponse = restTemplate.getForEntity("http://localhost:1080/testRest", String.class);
		System.out.println("response got is:" + actualResponse.getBody());
		assertEquals(expectedResult, actualResponse.getBody());
		mockserver.stop();
	}
}
