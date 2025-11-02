package StepDefinitions;

import Utilities.GlobalContext;
import Utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetBookingDetails extends Utils {

    RequestSpecification req;
    String url;
    Response res;

    @Given("user has access to the endpoints {string}")
    public void user_has_access_to_the_endpoint(String url) throws IOException {
        this.url=url;
        int ID= (int) GlobalContext.get("Id");
        req=given().spec(RequestSpec()).pathParams("key1",ID);
    }

    @When("user makes a request to view booking details using the booking ID")
    public void user_makes_a_request_to_view_booking_i_ds() {
        System.out.println("URL:"+url);
        res=req.when().get(url);
    }
    @When("user should see all the details of that particular booking Id.")
    public void user_makes_a_request_to_view_details_of_a_booking_id() {
        String firstName=getJsonPath(res,"firstname");
        String lastName=getJsonPath(res,"lastname");
        assertEquals(firstName,"Kiran");
        assertEquals(lastName,"Kumar");
    }
}
