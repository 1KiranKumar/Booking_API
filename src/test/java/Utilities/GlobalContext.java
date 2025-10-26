package Utilities;

public class GlobalContext {

    public static int bookingId;


    public static int getBookingId() {
        return bookingId;
    }

    public static void setBookingId(int bookingId) {
        GlobalContext.bookingId = bookingId;
    }

}
