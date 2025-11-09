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
import static org.junit.Assert.assertNull;

public class GetBookingDetails extends Utils {

    RequestSpecification req;
    GlobalContext context;

    public GetBookingDetails(GlobalContext context){
        this.context=context;
    }

    @When("user makes a request to view booking details using the booking ID")
    public void user_makes_a_request_to_view_booking_i_ds() throws IOException {
        System.out.println("URL:"+GlobalContext.get("endpoint"));
        int ID= (int) GlobalContext.get("Id");
        req=given().spec(RequestSpec()).pathParams("key",ID);
        context.res=req.when().get(GlobalContext.get("endpoint").toString());
    }

    @When("user should see all the details of that particular booking Id.")
    public void user_makes_a_request_to_view_details_of_a_booking_id() {
        String firstName=getJsonPath(context.res,"firstname");
        String lastName=getJsonPath(context.res,"lastname");
        assertEquals(firstName,"Kiran");
        assertEquals(lastName,"Kumar");
    }

    @When("user makes a request to view booking IDs from {string} and {string}")
    public void user_makes_a_request_to_view_booking_i_ds_from_and(String firstname, String lastname) throws IOException {
        req=given().spec(RequestSpec()).queryParam("firstname",firstname)
                .queryParam("lastname",lastname);
        context.res=req.when().get(GlobalContext.get("endpoint").toString());
    }

    @Then("user should see the booking Id of that particular firstname and lastname")
    public void user_should_see_the_booking_id_of_that_particular_firstname_and_lastname() {
        System.out.println("RESPNSE COntext:"+context.res);
        String BookingResId=getJsonPath(context.res,"bookingid");
        System.out.println(BookingResId);
    }


}
