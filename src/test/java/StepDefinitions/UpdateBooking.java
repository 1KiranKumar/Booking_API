package StepDefinitions;

import Pojo.Auth;
import Pojo.BookingDates;
import Pojo.CreateBooking;
import Utilities.GlobalContext;
import Utilities.Utils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

        String firstname=getJsonPath(context.res, "firstname");
        String lastname=getJsonPath(context.res, "lastname");
        assertEquals(firstname,"John");
        assertEquals(lastname,"Rambo");
    }



    @When("user makes a request to update first name {string} & Last name {string}")
    public void user_makes_a_request_to_update_first_name_last_name(String string, String string2) throws IOException {
        String token=GlobalContext.get("token").toString();
        String id=GlobalContext.get("Id").toString();
        JSONObject jb=new JSONObject();
        jb.put("firstname",string);
        jb.put("lastname",string2);

        req=given().spec(RequestSpec()).body(jb.toString()).pathParams("key",id).headers("Cookie","token="+token);
        context.res=req.when().patch(GlobalContext.get("endpoint").toString());

        String firstname=getJsonPath(context.res,"firstname");
        String lastname=getJsonPath(context.res,"lastname");
        assertEquals(firstname,"TwoPeople");
        assertEquals(lastname,"Lastname");

    }





}
