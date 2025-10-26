package Samp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Test {
    public static void main(String[] args) {
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
         given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("/booking/2821").then().log().all();

//        System.out.println(res.prettyPrint());
//        System.out.println(res.statusCode());
    }
}
