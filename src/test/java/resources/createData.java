package resources;

import Pojo.BookingDates;
import Pojo.CreateBooking;

public class createData {

    public CreateBooking CreatePayload(String firstName, String lastName){
        CreateBooking cb=new CreateBooking();
        BookingDates bd=new BookingDates();

        cb.setFirstname(firstName);
        cb.setLastname(lastName);
        cb.setTotalprice(1000);
        cb.setDepositpaid(false);
        bd.setCheckin("2025-01-01");
        bd.setCheckout("2025-01-10");
        cb.setBookingdates(bd);
        cb.setAdditionalneeds("HELLO");
        return cb;

    }
}
