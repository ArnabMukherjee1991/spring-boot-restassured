package com.jobportal.backend;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class JobDetailsIT {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.port = 8080;
    }

    @Test
    public void testFindAllJobs() {
        GraphQLQuery query = new GraphQLQuery();
        String queryString = "query {findAllJobs{jobTitle}}";
        query.setQuery(queryString);
        given().port(8080)
                .contentType(ContentType.JSON)
                .body(query)
                .when()
                .post("graphql")
                .then()
                .assertThat()
                .statusCode(200)
                .and().body("data.findAllJobs[0].jobTitle", org.hamcrest.Matchers.equalTo("JavaScript Developer"));
    }

    @Test
    public void test_GetJobById() {
        GraphQLQuery query = new GraphQLQuery();
        String findAllJobs = "query {" +
                "findAllJobs {" +
                "jobTitle" +
                "}" +
                "}";
        String getJobById = "query {" +
                "jobById(id: 1) {" +
                "jobTitle" +
                "}" +
                "}";
        query.setQuery(findAllJobs);
        query.setQuery(getJobById);
        RequestSpecification httpRequest = RestAssured.given();
        Map<String, String> headers = Map.of("Content-Type", "application/json");
        //Map<String, String>  params = Map.of("employeeId", "1234");
        Response response = httpRequest.headers(headers)
                .body(query)
                .post("/graphql");
        // Retrieve the body of the Response
        ResponseBody body = response.getBody();
        // By using the ResponseBody.asString() method, we can convert the  body
        // into the string representation.
        log.info("Response Body is: {} ", body.asString());
        assert response.getStatusCode() == 200;
        assert body.asString().contains("Senior Developer");
    }
}
