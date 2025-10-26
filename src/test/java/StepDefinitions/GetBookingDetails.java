package StepDefinitions;

import Utilities.GlobalContext;
import Utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetBookingDetails extends Utils {

    RequestSpecification req;
    String url;
    Response res;

    @Given("user has access to the endpoints {string}")
    public void user_has_access_to_the_endpoint(String url) throws IOException {
        this.url=url;
        int ID= GlobalContext.getBookingId();
        req=given().spec(RequestSpec()).pathParams("key1",ID);
    }

    @When("user makes a request to view booking IDs")
    public void user_makes_a_request_to_view_booking_i_ds() {
        System.out.println("URL:"+url);
        res=req.when().get(url);

    }
    @When("user makes a request to view details of a booking ID")
    public void user_makes_a_request_to_view_details_of_a_booking_id() {

    }

}
