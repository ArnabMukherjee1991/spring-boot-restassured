package com.jobportal.backend;

import com.jobportal.backend.model.Employee;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static com.jobportal.backend.util.APiConstants.ADD_Employee;
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
	void testGetEmployee() {
		RequestSpecification httpRequest = RestAssured.given();
		Map<String, String>  headers = Map.of("Content-Type", "application/json");
		Map<String, String>  params = Map.of("employeeId", "1234");
		Response response = httpRequest.headers(headers).queryParams(params).get("/getEmployee");
		// Retrieve the body of the Response
		ResponseBody body = response.getBody();
		// By using the ResponseBody.asString() method, we can convert the  body
		// into the string representation.
		log.info("Response Body is: {} " , body.asString());

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
