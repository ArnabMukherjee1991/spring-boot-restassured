package com.example.springbootrestassured;

import com.example.springbootrestassured.model.Employee;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.springbootrestassured.util.APiConstants.ADD_Employee;
import static io.restassured.RestAssured.given;
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SpringBootRestassuredApplicationTests {

	@BeforeAll
	public static void setup(){
		RestAssured.baseURI = "http://localhost:8080";
		RestAssured.port = 8080;
	}
	@Test
	void contextLoads() {

	}

	@Test
	void testAddEmployee() {
		Employee employee = Employee.builder()
				.setFname("John")
				.setLname("Doe")
				.setEmail("test@test.com").build();
		log.info("Employee: {}", employee);

		given().port(8080)
				.contentType("application/json")
				.body(employee)
				.when()
				.post(ADD_Employee)
				.then()
				.assertThat()
				.statusCode(201);


	}

}
