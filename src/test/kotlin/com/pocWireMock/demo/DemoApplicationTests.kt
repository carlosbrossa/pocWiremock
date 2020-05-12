package com.pocWireMock.demo

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.junit.jupiter.api.Assertions
import org.springframework.beans.factory.annotation.Autowired

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	lateinit var exampleController : ExampleController

	@Test
	fun contextLoads() {

		var result = exampleController.helloString()
		Assertions.assertEquals(result, "hop")

	}

}
