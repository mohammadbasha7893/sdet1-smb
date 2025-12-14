package day1;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo; // ✅ import matcher

import org.testng.annotations.Test;

public class lab002 {
	
	
	@Test
    public static void getapi() {
        RestAssured.baseURI = "https://library-api.postmanlabs.com";

        given().log().all()
            .header("api-key", "postmanrulz")
            .contentType("application/json")
        .when()
            .get("/books/785ac7bf-21de-49a8-9786-6acd332cc611") // ✅ path param
        .then().log().all()
            .assertThat()
            .statusCode(200)
            .body("author", equalTo("du")); // ✅ fixed matcher
    }
}