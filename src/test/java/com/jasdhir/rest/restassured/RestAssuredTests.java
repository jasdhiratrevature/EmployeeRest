package com.jasdhir.rest.restassured;

import static org.hamcrest.CoreMatchers.equalTo;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;

@ExtendWith(SpringExtension.class)
@SpringBootTest // (webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestAssuredTests {

	private ValidatableResponse validatableResponse;
	private ValidatableResponse validatableResponse1;

	/*
	 * @BeforeEach public void configureRestAssured() { baseURI =
	 * "http://localhost:9090"; }
	 */
	/* Get operation - Get the details of a Employee */
	@Test
	public void listUsers() {

		given().baseUri("http://localhost:9090/api/v1")
		.contentType(ContentType.JSON)
		.when().get("/employees")
		.then().assertThat().statusCode(200);

	}

	/* Get operation - Get the details of a Employee */
	@Test
	public void listAUser() {

		validatableResponse = given().baseUri("http://localhost:9090/api/v1")
				.contentType(ContentType.JSON)
				.when()	.get("/employees/10")
				.then().assertThat().log().all()
				.statusCode(200)
				.body("id", equalTo(10))
				.body("name", equalTo("abc"));
	}
	
	/* Create operation - Create a new Student */
    @Test
    public void createAUser() throws JSONException {
 
        JSONObject newEmp = new JSONObject();
 
        newEmp.put("name", "Ravi");
        newEmp.put("email", "rr@r.com");
        newEmp.put("phone", 123456);
 
        validatableResponse = given().baseUri("http://localhost:9090/api/v1")
                                     .contentType(ContentType.JSON).body(newEmp.toString())
                              .when()
                                      .post("/employees")
                              .then()
                                    .log().all().assertThat().statusCode(200);
 
        /* Verify that a new Employee is created */
        validatableResponse1 = given().baseUri("http://localhost:9090/api/v1")
                                     .contentType(ContentType.JSON)
                               .when()
                                     .get("/employees/11")
                               .then()
                                     .log().all().assertThat().statusCode(200)
                                     .body("id",equalTo(11))
                                     .body("name",equalTo("Ravi"));
                                    
 
    }
}
