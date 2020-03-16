package core.utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

/**
 * Generates access token.
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public class AccessToken {
    private static AccessToken accessToken;
    private static Response response;
    private static Object jsonResponse;
    private static Client client;

    /**
     * Constructor to initialize AccessToken.
     */
    private AccessToken() {
        initializeAccessToken();
    }

    /**
     * Gets instance of AccessToken.
     * @return AccessToken instance.
     */
    public static AccessToken getInstance() {
        if (accessToken == null) {
            accessToken = new AccessToken();
            client = new Client();
        }
        return accessToken;
    }

    /**
     * Initializes AccessToken.
     */
    private void initializeAccessToken()  {
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
        setClient(jsonResponse);
    }

    /**
     * Sets client values.
     */
    private void setClient(final Object jsonResponse) {
        client.setAccessToken("");
        client.setInstanceUrl("");
        client.setId("");
        client.setTokenType("");
        client.setIssuedAt("");
        client.setSignature("");
        client.setAuthUrl("");
    }

    /**
     * Gets client instance.
     * @return
     */
    public Client getClient() {
        return client;
    }
}
