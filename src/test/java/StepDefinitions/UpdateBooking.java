package StepDefinitions;

import Pojo.Auth;
import Pojo.BookingDates;
import Pojo.CreateBooking;
import Utilities.GlobalContext;
import Utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UpdateBooking extends Utils {
    GlobalContext context;

    public UpdateBooking(GlobalContext context){
        this.context=context;
    }

    @When("user creates a auth token with credential {string} & {string}")
    public void user_creates_a_auth_token_with_credential(String string, String string2) throws IOException {
        Auth auth=new Auth();
        auth.setPassword(string2);
        auth.setUsername(string);
        req=given().spec(RequestSpec()).body("{\n" +
                "    \"username\" : \""+auth.getUsername()+"\",\n" +
                "    \"password\" : \""+auth.getPassword()+"\"\n" +
                "}");
        context.res=req.when().post(GlobalContext.get("endpoint").toString());
        String tokenID=getJsonPath(context.res,"token");
        GlobalContext.put("token",tokenID);
    }

    @When("user updates the details of a booking {string} {string} {string} {string} {string} {string} {string}")
    public void user_updates_the_details_of_a_booking(String string, String string2, String string3, String string4, String string5, String string6, String string7) throws IOException {
        CreateBooking cb=new CreateBooking();
        BookingDates bd=new BookingDates();
        cb.setFirstname(string);
        cb.setLastname(string2);
        cb.setTotalprice(Integer.parseInt(string3));
        cb.setDepositpaid(Boolean.parseBoolean(string4));
        bd.setCheckin(string5);
        bd.setCheckout(string6);
        cb.setBookingdates(bd);
        cb.setAdditionalneeds(string7);

        String id=GlobalContext.get("Id").toString();
        req=given().spec(RequestSpec()).body(cb).pathParams("key",id).headers("Cookie","token="+GlobalContext.get("token").toString());
        context.res=req.when().put(GlobalContext.get("endpoint").toString());


    }



}
