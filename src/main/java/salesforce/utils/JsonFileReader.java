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
    private static final String FILE_PATH = "src/main/java/salesforce/jsonfiles/";

    /**
     * Reads json file values.
     * @param fileName of json file.
     * @return json file values.
     */
    public static String jsonReader(final String fileName) {
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
        return jsonObject.toJSONString();
    }
}
