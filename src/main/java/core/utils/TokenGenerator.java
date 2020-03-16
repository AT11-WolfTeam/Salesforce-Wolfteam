package core.utils;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TokenGenerator {
    private static TokenGenerator tokenGenerator;
    private static Response response;
    private static Map jsonResponse;

    private TokenGenerator() {
        initializeTokenGenerator();
    }

    private void initializeTokenGenerator()  {
        response = given()
                .param("username", GradleReader.getInstance().getUser().getUsername())
                .param("password", GradleReader.getInstance().getUser().getPassword()
                        + GradleReader.getInstance().getUser().getToken())
                .param("grant_type", GradleReader.getInstance().getUser().getGrantType())
                .param("client_id", GradleReader.getInstance().getUser().getClientId())
                .param("client_secret", GradleReader.getInstance().getUser().getClientSecret())
                .when().post(GradleReader.getInstance().getUser().getAuthUrl());
//        jsonResponse = response.getBody().toString();
    }

    public Map getJsonResponse() {
        return jsonResponse;
    }
}
