package Utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    public static RequestSpecification req;

    public RequestSpecification RequestSpec() throws IOException {
        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("Logs.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("BaseURI"))
                    .setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
            return req;
        }
        return req;
    }

    public String getGlobalValue(String key) throws IOException {
        Properties prop=new Properties();
        FileInputStream fs=new FileInputStream("D:\\Downloads\\Booking_API\\API_Booking\\Global.properties");
        prop.load(fs);
        return prop.getProperty(key);
    }
}
