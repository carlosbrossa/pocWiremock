package com.pocWireMock.demo

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.GsonJsonParser
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.converter.json.GsonBuilderUtils
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class DemoApplicationIntegrationTests {

	@Autowired
	lateinit var exampleController : ExampleController

	var wireMockServer = WireMockServer(8900)

	@BeforeEach
	fun setup(){
		wireMockServer.start()
	}

	@AfterEach
	fun close(){
		wireMockServer.stop()
	}


	@Test
	fun shayShayTest(){

		var resultExpected = "{\"source\":\"Shay Shay API\",\"quotes\":[\"I didn't bother with trash-talking people's moms, wives, or girlfriends. I was like, 'Hold on, man, you mean to tell me you're making \$10 million a year? That's \$9 million, \$999,999 too much!' That ate them up.\",\"You just don't wake up one morning and say, 'I'm going to be a talker. I'm going to be a braggart.' It's something you achieve over the years, and you get better at it. Obviously, I've gotten pretty good at it.\",\"A mistake made more than once is a decision\"]}"

		wireMockServer.stubFor(
				WireMock.get(WireMock.urlMatching("/random\\?limit=3"))
						.willReturn(WireMock.aResponse().withBody(
								resultExpected
						).withHeader("Content-Type", "application/json")))
		var result = exampleController.shayShaySay()

		
		var resultJson = ObjectMapper().writeValueAsString(result)
		Assertions.assertEquals(resultJson, resultExpected)

	}

}
