package com.niladri.product_service;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mongoDBContainer.start();
	}

	@Test
	void shouldCreateProduct() {
		// Test logic to create a product
		String requestBody = """
								{
					"name": "T-shirt",
				    "description":"T shirt",
				    "price":999,
				    "discount":20,
				    "stockQuantity":2,
				    "category":"Shirt"
				}
								""";

				RestAssured.given()
					.contentType("application/json")
					.body(requestBody)
					.when()
					.post("/api/products/")
					.then()
					.statusCode(201)
					/* .body("id", Matchers.notNullValue()) */
					.body("name", Matchers.equalTo("T-shirt"))
					.body("description", Matchers.equalTo("T shirt"))
					.body("price", Matchers.equalTo(999))
					.body("discount", Matchers.equalTo(20))
					.body("stockQuantity", Matchers.equalTo(2))
					/* .body("category", Matchers.equalTo("Shirt")) */
					;
	}

}
