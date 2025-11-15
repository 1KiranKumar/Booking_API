package StepDefinitions;

import Utilities.GlobalContext;
import Utilities.Utils;
import io.cucumber.java.en.When;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeleteBooking extends Utils {
    GlobalContext context;

    public DeleteBooking(GlobalContext context){
        this.context=context;
    }

    @When("user makes a request to delete booking")
    public void user_makes_a_request_to_delete_booking() throws IOException {
        String token= GlobalContext.get("token").toString();
        String id=GlobalContext.get("Id").toString();

        req=given().spec(RequestSpec()).pathParams("key",id).headers("cookie","token="+token);
        context.res=req.when().delete(GlobalContext.get("endpoint").toString());
        System.out.println(context.res.asString());

        assertEquals(context.res.asString(),"Created");
    }


}
