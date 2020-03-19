/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import salesforce.entities.SalesforceUser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Manages account api requests.
 *
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public class JsonFileReader {
    private String fileName;
    private static final String USERNAME_KEY = "Username";
    private static final String PASSWORD_KEY = "Password";
    private static final String FILE_PATH = "src/main/java/salesforce/jsonfiles/";

    /**
     * Builds a JsonFileReader.
     * @param fileName contains the jsonfile name.
     */
    public JsonFileReader(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads json file values.
     *
     * @return json file values.
     */
    private JSONObject jsonReader() {
        JSONObject jsonObject = new JSONObject();
        try {
            Object jsonValues = new JSONParser().parse(new FileReader(FILE_PATH + fileName));
            jsonObject = (JSONObject) jsonValues;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * Returns a Salesforce user credential.
     * @param userType receives a String value.
     * @return SalesforceUser object.
     */
    public SalesforceUser getUser(final String userType) {
        JSONObject jsonObject = jsonReader();
        jsonObject = (JSONObject) jsonObject.get(userType);
        SalesforceUser salesforceUser = new SalesforceUser();
        salesforceUser.setUsername((String) jsonObject.get(USERNAME_KEY));
        salesforceUser.setPassword((String) jsonObject.get(PASSWORD_KEY));
        return salesforceUser;
    }
}
