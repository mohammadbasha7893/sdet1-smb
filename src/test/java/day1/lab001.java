package day1;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class lab001 {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://library-api.postmanlabs.com";

        given().log().all()
            .header("api-key", "postmanrulz")
            .contentType("application/json")
            .body("{\r\n"
                + "\"title\": \"Learn Postman With basha2\",\r\n"
                + "\"author\": \"basha\",\r\n"
                + "\"genre\": \"computers\",\r\n"
                + "\"yearPublished\": 2025\r\n"
                + "}")
        .when()
            .post("/books")
        .then().log().all()
            .statusCode(201); 
    }
}