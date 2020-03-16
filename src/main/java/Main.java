import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import salesforce.restclient.Authentication;


public class Main {
    public static void main(String[] args) {
        RequestSpecification response = Authentication.authenticationRequest();
        String value = response.toString();
        System.out.println(value);
    }
}
