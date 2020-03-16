package core.utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

/**
 * Generates token.
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public class TokenGenerator {
    private static TokenGenerator tokenGenerator;
    private static Response response;
    private static Object jsonResponse;

    private TokenGenerator() {
        initializeTokenGenerator();
    }

    public static TokenGenerator getInstance() {
        if (tokenGenerator == null) {
            tokenGenerator = new TokenGenerator();
        }
        return tokenGenerator;
    }

    private void initializeTokenGenerator()  {
        String userToken = GradleReader.getInstance().getUser().getToken();
        response = given()
                .param("username", GradleReader.getInstance().getUser().getUsername())
                .param("password", GradleReader.getInstance().getUser().getPassword()
                        + userToken)
                .param("grant_type", GradleReader.getInstance().getUser().getGrantType())
                .param("client_id", GradleReader.getInstance().getUser().getClientId())
                .param("client_secret", GradleReader.getInstance().getUser().getClientSecret())
                .when().post(GradleReader.getInstance().getUser().getAuthUrl());
        jsonResponse = response.getBody();
    }

    public Object getJsonResponse() {
        return jsonResponse;
    }
}
