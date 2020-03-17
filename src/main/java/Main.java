import core.api.AccountApi;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import salesforce.requestapi.Authentication;

import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Response account = AccountApi.postAccount("Account.json");
        int accountValue = account.getStatusCode();
        System.out.println(accountValue);
    }
}
