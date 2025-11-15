package StepDefinitions;

import Utilities.GlobalContext;
import Utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.createData;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateBooking extends Utils {
    GlobalContext context;

    public CreateBooking(GlobalContext context){
        this.context=context;
    }

    @Given("user has access to the endpoint {string}")
    public void user_has_access_to_the_endpoint(String url) throws IOException {
        GlobalContext.put("endpoint",url);
    }

    @When("user creates a booking using the required body")
    public void user_creates_a_booking_using_the_required_body() throws IOException {
        createData data=new createData();

        req=given().spec(RequestSpec())
                .body(data.CreatePayload("Kiran","Kumar"));
        context.res=req.when().post(GlobalContext.get("endpoint").toString());
    }

    @Then("user should get a response code {int}")
    public void user_should_get_a_response_code(int Code) {
        context.res.then().log().all();
        assertEquals(context.res.getStatusCode(),Code);
    }

    @Then("verify that the Id is not null")
    public void verify_that_the_id_is_not_null() {
        JsonPath js=new JsonPath(context.res.asString());
        int ID=Integer.parseInt(js.getString("bookingid"));
        System.out.println("ID:"+js.getString("bookingid"));
        System.out.println("NAME:"+js.getString("booking.firstname"));
        GlobalContext.put("Id",ID);
    }
}
